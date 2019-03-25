package chapter10;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lz on 2017/3/20.
 */
public class SessionTest extends  BaseTest {

    @Test
    public void testGetSession() throws Exception{
        login("classpath:shiro.ini","zhang","123");

        Subject subject = subject();
        Session session = subject.getSession();//获取session会话

        System.out.println(session.getId());//会话ID
        System.out.println(session.getHost());//获取登陆主机地址
        System.out.println(session.getTimeout());//超时时间
        System.out.println(session.getStartTimestamp());//会话创建时间
        System.out.println(session.getLastAccessTime());//最后访问时间

        Thread.sleep(1000L);
        session.touch();//更新最后访问时间
        System.out.println(session.getLastAccessTime());

        session.setAttribute("key","123");
        Assert.assertEquals("123",session.getAttribute("key"));
        session.removeAttribute("key");


    }
}
