package com.study.bfys._4.thread.pool;

/**
 * @className: ThreadPool
 * @description:
 * @author: lz-mac
 * @date: 2020/9/16 14:55
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public interface ThreadPool<T extends Runnable> {

    /**
     * 执行一个job，这个job需要继承runnable
     *
     * @param job
     */
    void execute(T job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 添加工作线程
     *
     * @param num
     */
    void addWorks(int num);

    /**
     *减少工作线程
     * @param unm
     */
    void removeWork(int unm);

    /**
     * 获取正在等待执行的job数量
     * @return
     */
    int getJobSize();
}
