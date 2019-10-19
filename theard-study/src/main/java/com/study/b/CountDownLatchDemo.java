package com.study.b;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: CountDownLatchDemo
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2019/10/18 20:12
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class CountDownLatchDemo implements Runnable {

    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    public void run() {
        try {
            // 模拟检查
            Thread.sleep(new Random().nextInt(10)*1000);
            System.out.println("check complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            end.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for(int i =0;i<10;i++){
            exec.submit(demo);
        }
        // 等待检查
        end.await();
        // 发射火箭
        System.out.println("Fire!");
        exec.shutdown();
    }
}
