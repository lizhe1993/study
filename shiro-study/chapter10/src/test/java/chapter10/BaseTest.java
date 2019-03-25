package chapter10;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;
import org.apache.shiro.mgt.SecurityManager;

/**
 * Created by lz on 2017/3/20.
 */
public abstract class BaseTest {


    @Before
    public void setUp(){}

    @After
    public void tearDown()throws Exception{
        ThreadContext.unbindSubject();
    }

    protected void login(String configFile,String username,String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);

        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setHost("10.83.1.1");
        subject.login(token);
    }

    public Subject subject(){
        return SecurityUtils.getSubject();
    }

}
