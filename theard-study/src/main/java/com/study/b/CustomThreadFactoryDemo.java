package com.study.b;

import java.util.concurrent.*;

/**
 * @ClassName: CustomThreadFactoryDemo
 * @Description:
 * @Date: 2019/10/19 17:04
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class CustomThreadFactoryDemo {

    public static class MyTask implements Runnable {
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<Runnable>(),
                new ThreadFactory() {
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r);
                        t.setDaemon(true);
                        System.out.println("create " + t);
                        return t;
                    }
                });
        for(int i=0;i<5;i++){
            es.submit(myTask);
        }
        Thread.sleep(2000);
    }
}
