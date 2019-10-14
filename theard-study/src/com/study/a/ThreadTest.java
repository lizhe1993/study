package com.study.a;

/**
 * @author lz
 * ClassName: ThreadTest
 * Description:
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/1/2 18:08
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ThreadTest extends Thread {

    public String name;

    public ThreadTest(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(name + "运行:" + i);
            try {
                sleep((int) (Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("A");
        ThreadTest t2 = new ThreadTest("B");
        t1.start();
        t2.start();
    }
}
