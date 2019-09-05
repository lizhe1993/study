package com.study;

/**
 * @ClassName: VolatileNotAtomic
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2019/8/26 17:00
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class VolatileNotAtomic {
    //volatile 并不能解决线程的原子性

    private static volatile long count = 0L;

    private static final int NUMBER = 10000;


    public static void main(String[] args) {
        SubtractThread sub = new SubtractThread();

        sub.start();

        for (int i = 0; i < NUMBER; i++) {
            synchronized (VolatileNotAtomic.class){
                count++;
            }
        }
        while (sub.isAlive()) {
        }
        System.out.println("count最后结果为：" + count);
    }


    private static class SubtractThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                synchronized (VolatileNotAtomic.class){
                    count--;
                }
            }
        }
    }


}
