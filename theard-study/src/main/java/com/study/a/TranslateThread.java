package com.study.a;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: TranslateThread
 * @Description:
 * @Date: 2019/8/26 17:29
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class TranslateThread extends Thread {

    private String content;

    private final CountDownLatch count;

    public TranslateThread(String content, CountDownLatch count) {
        this.content = content;
        this.count = count;
    }

    @Override
    public void run() {
        if (Math.random() > 0.5) {
            throw new RuntimeException("原文存在非法字符");
        }

        System.out.println(content + "的翻译已经完成，译文是....");
        count.countDown();
    }
}