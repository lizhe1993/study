package com.study.bfys.utils;

import java.util.concurrent.TimeUnit;

/**
 * @className: SleepUtils
 * @description:
 * @author: lz-mac
 * @date: 2020/8/28 23:34
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class SleepUtils {

    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }
}
