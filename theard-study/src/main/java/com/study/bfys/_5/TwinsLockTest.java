package com.study.bfys._5;

import com.study.bfys.utils.SleepUtils;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Lock;

/**
 * @className: TwinsLockTest
 * @description:
 * @author: lz-mac
 * @date: 2020/9/19 21:57
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class TwinsLockTest {

    @Test
    public void test() {

        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        // 启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        //每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }

}
