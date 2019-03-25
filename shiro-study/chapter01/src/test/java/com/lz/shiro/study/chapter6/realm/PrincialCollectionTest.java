package com.lz.shiro.study.chapter6.realm;

import com.lz.shiro.study.chapter6.BaseTest;
import com.lz.shiro.study.chapter6.entity.User;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Set;

/**
 * Created by lz on 2017/3/13.
 */
public class PrincialCollectionTest extends BaseTest {

    @Test
    public void test(){
        login("classpath:chapter6/shiro-multirealm.ini","zhang","123");
        Subject subject = subject();

        Object primaryPrincipal1 = subject.getPrincipal();
        PrincipalCollection principalCollection = subject.getPrincipals();

        Object primaryPrincipal2 = principalCollection .getPrimaryPrincipal();

        Assert.assertEquals(primaryPrincipal1, primaryPrincipal2);

        Set<String> realmNames = principalCollection.getRealmNames();
        System.out.println(realmNames);
        Set<Object> principts = principalCollection.asSet();
        System.out.println(principts);

        Collection<User> users = principalCollection.fromRealm("my realm 3");
        System.out.println(users);

    }
}
