package com.study.bfys._4;

import com.study.bfys.utils.SleepUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @className: WaitNotify
 * @description:
 * @author: lz-mac
 * @date: 2020/8/28 23:13
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread wait = new Thread(new Wait(),"WaitThread");
        wait.start();
        SleepUtils.second(1);
        Thread notify = new Thread(new Notify(),"NotifyThread");
        notify.start();
    }


    static class Wait implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 当条件不满足时候，继续wait，同时释放lock锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true.wait @ "
                                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                    // 条件满足时，完成工作
                    System.out.println(Thread.currentThread() + " flag is false. running @"
                            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

                }
            }
        }
    }


    static class Notify implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有lock的monitor
            synchronized (lock) {
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
                // 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify @" +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(1);
            }
            // 再次加鎖
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @" +
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                SleepUtils.second(1);
            }
        }
    }

}
