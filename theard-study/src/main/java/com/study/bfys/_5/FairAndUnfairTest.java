package com.study.bfys._5;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @className: FairAndUnfairTest
 * @description:
 * @author: lz-mac
 * @date: 2020/9/19 22:37
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class FairAndUnfairTest {
    private static Lock fairLock = new ReentrantLock2(true);

    private static Lock unfairLock = new ReentrantLock2(false);


    @Test
    public void fair() {
        testLock(fairLock);
    }

    @Test
    public void unfair() {
        testLock(unfairLock);
    }

    // 测试类
    private void testLock(Lock lock) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(lock), i + "");
            thread.start();
        }

    }


    private static class Job implements Runnable {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    Thread currentThread = Thread.currentThread();
                    Collection<Thread> queuedThreads = ((ReentrantLock2) lock).getQueuedThreads();
                    String waitingTheadNames = queuedThreads.stream().map(x -> x.getName()).collect(Collectors.joining(","));
                    System.out.println("Lock by:" + currentThread.getName() + ". Waiting by [" + waitingTheadNames + "]");
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
