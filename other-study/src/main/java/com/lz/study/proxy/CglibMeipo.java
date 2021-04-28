package com.lz.study.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName: CglibMeipo
 * @Description:
 * @Date: 2020/4/22 11:14
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class CglibMeipo implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object o = proxy.invokeSuper(obj, args);
        after();
        return o;
    }

    public Object getInstance(Class<?> clazz) throws Exception {
        Enhancer enhancer = new Enhancer();
        // 要把哪个设置为即将发生的新类的父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
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
            Customer customer = (Customer) new CglibMeipo().getInstance(Customer.class);
            customer.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
