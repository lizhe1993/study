package com.study.bfys._4.data.pool;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.Map;

/**
 * @className: ConnectionPool
 * @description:
 * @author: lz-mac
 * @date: 2020/9/12 15:15
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ConnectionPool {

    private final LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    /**
     * 释放连接
     *
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 释放连接需要进行通知，这样别的消费者能够感知连接池中有多余的连接了
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 获取连接，超时返回null
     *
     * @param mills
     * @return
     */
    public Connection fetchConnection(Long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills <= 0) {
                // 完全超时
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                Long future = System.currentTimeMillis() + mills;
                Long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;

                if (!pool.isEmpty()) {
                    result = pool.getFirst();
                }
                return result;

            }
        }

    }
}
