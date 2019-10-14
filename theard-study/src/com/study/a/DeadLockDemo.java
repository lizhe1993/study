package com.study.a;

/**
 * ClassName: DeadLockDemo
 * Description: 死锁demo
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/2/18 14:47
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class DeadLockDemo {

    private static String A = "A";

    private static String B = "B";

    private void demoLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println(2);
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().demoLock();
    }
}
