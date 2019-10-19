package com.study.b;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @ClassName: RateLimiterDemo
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2019/10/19 10:40
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class RateLimiterDemo {

    static RateLimiter limiter = RateLimiter.create(2);

    public static class Task implements Runnable {
        public void run() {
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            if (!limiter.tryAcquire()) {
                limiter.acquire();
            }
            new Thread(new Task()).start();
        }
    }
}
