package com.lz.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: JDKMeiPo
 * @Description:
 * @Date: 2020/4/21 17:20
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class JDKMeiPo implements InvocationHandler {
    /**
     * 被代理对象
     */
    private Object target;

    /**
     * 初始化化对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object obj = method.invoke(this.target, args);
        this.after();
        return obj;
    }


    private void before() {
        System.out.println("我是媒婆：我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after() {
        System.out.println("如果合适的化，就开始办事");
    }


    public static void main(String[] args) {
        try {
            Person person = (Person)new JDKMeiPo().getInstance(new Customer());
            person.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
