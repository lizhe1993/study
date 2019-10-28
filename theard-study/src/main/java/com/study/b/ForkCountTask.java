package com.study.b;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @ClassName: ForkCountTask
 * @Description:
 * @Author: LiZhe lizhej@enn.cn
 * @Date: 2019/10/21 9:57
 * @History: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ForkCountTask extends RecursiveTask<Long> {

    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkCountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 分成100个小任务
            long step = (start + end) / 100;
            ArrayList<ForkCountTask> subTasks = new ArrayList<ForkCountTask>();
            long pos = start;
            for (int i = 0; i < 100; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                ForkCountTask subTask = new ForkCountTask(pos, lastOne);
                pos += step + 1;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (ForkCountTask t : subTasks) {
                sum += t.join();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkCountTask task = new ForkCountTask(0,200000L);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);
        try {
            long res = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
