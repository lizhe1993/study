package com.study.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CountDownLatchTest
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2019/8/26 17:24
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(3);
        Thread t1 = new TranslateThread("1st content", c);
        Thread t2 = new TranslateThread("2st content", c);
        Thread t3 = new TranslateThread("3st content", c);

        t1.start();
        t2.start();
        t3.start();

        c.await(10, TimeUnit.SECONDS);

        System.out.println("所有线程执行完成");
    }

}
