package com.study.bfys._4.thread.pool;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import sun.jvm.hotspot.debugger.ThreadContext;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @className: DefaultThreadPool
 * @description:
 * @author: lz-mac
 * @date: 2020/9/16 16:18
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    // 线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    // 线程池默认数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    // 线程池最小限制数
    private static final int MIX_WORKER_NUMBERS = 1;

    /**
     * 这是一个工作列表，将会向里面插入工作
     */
    private final LinkedList<Job> jobs = new LinkedList<>();
    /**
     * 工作列表
     */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    /**
     * 工作者线程数量
     */
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    /**
     * 线程编号生成
     */
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        this.initializeWorks(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIX_WORKER_NUMBERS ? MIX_WORKER_NUMBERS : num;
        this.initializeWorks(workerNum);
    }

    private void initializeWorks(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + this.threadNum.incrementAndGet());
            thread.start();
        }
    }


    /**
     * 工作者，负责消费
     */
    class Worker implements Runnable {
        // 是否工作
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    // 如果工作队列为空，则进行等待
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            // 感知到外部对WorkerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    // 取出一个job
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        // 忽略异常
                    }
                }
            }
        }

        public void shutdown() {
            running = false;
        }
    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        this.workers.stream().forEach(x -> x.shutdown());
    }

    @Override
    public void addWorks(int num) {
        synchronized (jobs) {
            // 限制新增的Worker数量不能超过最大值
            if (num + this.workerNum > MAX_WORKER_NUMBERS) {
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            this.initializeWorks(num);
            this.workerNum += num;

        }
    }

    @Override
    public void removeWork(int num) {
        synchronized (jobs) {
            if (num >= this.workerNum) {
                throw new IllegalArgumentException("beyond workNum");
            }
            // 按照给定的数量停止Worker
            int count = 0;
            while (count < num) {
                Worker worker = this.workers.get(count);
                worker.shutdown();
                count++;
            }
            this.workerNum -= count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
}
