package com.study.bfys._4.data.pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @className: ConnectionDeriver
 * @description:
 * @author: lz-mac
 * @date: 2020/9/12 15:22
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ConnectionDriver {


    static class ConnectionHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100);

            }
            return null;
        }

    }

    public ConnectionDriver() {
    }

    //  创建一个Connection的一个代理，在commit时候进行进行休眠100毫秒
    public static final Connection createConnection() {

        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());


    }
}
