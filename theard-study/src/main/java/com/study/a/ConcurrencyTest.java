package com.study.a;

/**
 * ClassName: ConcurrencyTest
 * Description: 测试线程穿行和并行的时间
 * Date: 2019/2/18 14:23
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ConcurrencyTest {

    private static final long count = 1001;

    private static void concurrency() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });

        thread.start();

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - startTime;

        thread.join();

        System.out.println("concurrency:" + time + "ms,b=" + b);

    }

    private static void serial() {
        long startTime = System.currentTimeMillis();

        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - startTime;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }


    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

}
