package com.study.a;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: UserTask
 * @Description:
 * @Date: 2019/9/3 11:22
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class UserTask implements Runnable {
    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("runing_" + count.getAndIncrement());
    }
}
