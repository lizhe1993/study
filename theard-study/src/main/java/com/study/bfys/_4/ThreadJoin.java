package com.study.bfys._4;

import com.study.bfys.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * @className: ThreadJoin
 * @description:
 * @author: lz-mac
 * @date: 2020/9/2 21:31
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread pt = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domain(pt), String.valueOf(i));
            thread.start();
            pt = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");

    }


    static class Domain implements Runnable {

        private Thread thread;

        public Domain(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }


}
