package chapter10.web.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * Created by lz on 2017/3/21.
 */
public class MySessionListener1 implements SessionListener {

    public void onStart(Session session) {
        System.out.println("会话创建"+session.getId());
    }

    public void onStop(Session session) {
        System.out.println("会话过期"+session.getId());
    }

    public void onExpiration(Session session) {
        System.out.println("会话停止"+session.getId());
    }
}
