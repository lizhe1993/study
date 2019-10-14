package com.study.a;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: UserThreadPool
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2019/9/3 11:24
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class UserThreadPool {

    public static void main(String[] args) {
        // 缓存队列设置固定长度为2，为了快速触发rejectHandler
        BlockingQueue queue = new LinkedBlockingQueue(2);

        // 假设外部任务线程的来源由机房1和机房2的混合调用
        UserThreadFactory f1 = new UserThreadFactory("第 1 机房");
        UserThreadFactory f2 = new UserThreadFactory("第 2 机房");

        UserRejectHandler handler = new UserRejectHandler();

        // 核心线程为1 最大线程为2,为了宝成触发 rejectHandler
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f1, handler);

        // 利用第二个线程工厂实例创建第二个线程池
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f2, handler);

        // 创建500个任务线程
        Runnable task = new UserTask();
        for (int i = 0; i < 250; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }

    }
}
