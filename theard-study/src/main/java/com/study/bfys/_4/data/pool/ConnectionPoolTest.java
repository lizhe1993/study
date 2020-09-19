package com.study.bfys._4.data.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @className: ConnectionPoolTest
 * @description:
 * @author: lz-mac
 * @date: 2020/9/12 17:55
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ConnectionPoolTest {

    static ConnectionPool pool = new ConnectionPool(10);
    /**
     * 保证所有ConnectionRunner能够同时开始
     */
    static CountDownLatch start = new CountDownLatch(1);

    /**
     * main线程将会等待所有ConnectionRunner结束后才能继续执行
     */
    static CountDownLatch end;

    static class ConnectionRunner implements Runnable {
        // 统计
        int count;
        // 获取线程数
        AtomicInteger got;
        // 为获取新线程数
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                // 同时等待在 start 对象上，
                start.wait();
            } catch (Exception e) {
            }
            while (count > 0) {
                try {
                    // 从线程池中获取连接，如果超过1s没有获取到，则返回为空
                    // 分别统计连接获取数量got 获取为获取连接数据量notGot
                    Connection connection = pool.fetchConnection(1000L);
                    if (connection != null) {
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException | SQLException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // 线程数量，可以修改线程数量进行观察
        int threadCount = 10000;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection " + notGot);
    }


}
