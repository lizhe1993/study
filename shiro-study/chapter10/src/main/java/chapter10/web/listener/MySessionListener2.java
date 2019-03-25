package chapter10.web.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

/**
 * Created by lz on 2017/3/21.
 */
public class MySessionListener2 extends SessionListenerAdapter {

    @Override
    public void onStart(Session session) {
        System.out.println("会话创建：" + session.getId());
    }
}
