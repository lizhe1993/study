package chapter12.service;

import chapter12.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by lz on 2017/3/10.
 */
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private String algrithName;

    private int hashlterations;

    public void encryptyPassword(User user){
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algrithName,user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),hashlterations).toHex();
        user.setPassword(newPassword);
    }

    public String getAlgrithName() {
        return algrithName;
    }

    public void setAlgrithName(String algrithName) {
        this.algrithName = algrithName;
    }

    public int getHashlterations() {
        return hashlterations;
    }

    public void setHashlterations(int hashlterations) {
        this.hashlterations = hashlterations;
    }
}
