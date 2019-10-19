package com.study.a;

import java.util.concurrent.Semaphore;

/**
 * @ClassName: CustomCheckWindow
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2019/8/26 17:33
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class CustomCheckWindow {

    public static void main(String[] args) {
        // 设定3个信号量，即3个窗口
        Semaphore s = new Semaphore(1);
        for (int i = 1; i <= 10; i++) {
            new SecurityCheckThread(i, s).start();
        }

    }

    private static class SecurityCheckThread extends Thread {
        private int seq;

        private Semaphore semaphore;

        public SecurityCheckThread(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {

            try {
                semaphore.acquire();
                System.out.println("NO." + seq + "乘客，正在检验中");

                //假设号码是整除2的乘客人身份可以人员，需要花更长时间处理
                if (seq % 2 == 0) {
                    Thread.sleep(1000);
                    System.out.println("NO." + seq + "乘客，身份可疑不能出国！");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("NO." + seq + "乘客，已完成服务。");
            }

        }
    }
}
