package com.lz.shiro.study.chapter6.service;

import com.lz.shiro.study.chapter6.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by lz on 2017/3/10.
 */
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algrithName="md5";

    private final int hashlterations=2;

    public void encryptyPassword(User user){
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algrithName,user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),hashlterations).toHex();
        user.setPassword(newPassword);
    }
}
