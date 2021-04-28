package com.study.bfys._5;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @className: Cache
 * @description:
 * @author: lz-mac
 * @date: 2020/9/20 01:29
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class Cache {

    private static final Map<String, Object> cache = new HashMap<>();

    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private static ReentrantReadWriteLock.ReadLock rl = rwl.readLock();

    private static ReentrantReadWriteLock.WriteLock wl = rwl.writeLock();

    public static final Object get(String key) {
        rl.lock();
        try {
            return cache.get(key);
        } finally {
            rl.unlock();
        }
    }

    public static final Object put(String key, Object object) {
        wl.lock();
        try {
            return cache.put(key, object);
        } finally {
            wl.unlock();
        }
    }

    public static final void clear() {
        wl.lock();
        try {
            cache.clear();
        } finally {
            wl.unlock();
        }
    }


    public static void main(String[] args) {
        int cap = 1;
        System.out.println(cap <<= 1);
    }
}
