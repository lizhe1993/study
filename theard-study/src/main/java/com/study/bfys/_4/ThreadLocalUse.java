package com.study.bfys._4;

import com.study.bfys.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * @className: ThreadLocalUse
 * @description:
 * @author: lz-mac
 * @date: 2020/9/10 14:06
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ThreadLocalUse {
    /**
     * 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
     */

    private static final ThreadLocal<Long> TIME_THREAD_LOCAL = new ThreadLocal<Long>() {

        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };


    public static final void begin(){
        TIME_THREAD_LOCAL .set(System.currentTimeMillis());
    }

    public static Long end(){
        return System.currentTimeMillis() - TIME_THREAD_LOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalUse.begin();

        TimeUnit.SECONDS.sleep(5);

        System.out.println(ThreadLocalUse.end());
    }




}
