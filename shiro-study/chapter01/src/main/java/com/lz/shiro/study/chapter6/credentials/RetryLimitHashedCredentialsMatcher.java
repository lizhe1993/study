package com.lz.shiro.study.chapter6.credentials;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by lz on 2017/3/10.
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Ehcache passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(){
        CacheManager cacheManager = CacheManager.newInstance(CacheManager.class.getClassLoader().getResource("chapter6/ehcache.xml"));
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username=(String) token.getPrincipal();
        //retry count+1
        Element element = passwordRetryCache.get(username);
        if(element==null){
            element = new Element(username,new AtomicInteger());
            passwordRetryCache.put(element);
        }

        AtomicInteger retryCount =(AtomicInteger) element.getObjectValue();
        if(retryCount.incrementAndGet()>5){
            //if retry count > 5 throw
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token,info);

        if(matches){
            passwordRetryCache.remove(username);
        }

        return matches;
    }
}
