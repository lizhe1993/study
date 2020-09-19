package com.study.bfys._5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @className: TwinsLock
 * @description:
 * @author: lz-mac
 * @date: 2020/9/18 18:03
 * @history: <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class TwinsLock implements Lock {


    private static class Sync extends AbstractQueuedLongSynchronizer {

        public Sync(int count) {
            if (count < 0) {
                throw new IllegalArgumentException("count must large than zero.");
            }
            this.setState(count);
        }

        @Override
        protected long tryAcquireShared(long reduceCount) {
            for (; ; ) {
                long current = this.getState();
                long newCurrent = current - reduceCount;
                if (newCurrent < 0 || this.compareAndSetState(current, newCurrent)) {
                    return newCurrent;
                }
            }
        }


        @Override
        protected boolean tryReleaseShared(long returnCount) {
            for (; ; ) {
                long state = this.getState();
                long newState = state + returnCount;
                if (compareAndSetState(state, newState)) {
                    return true;
                }
            }
        }
    }


    private final Sync sync = new Sync(2);

    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void unlock() {
        this.sync.releaseShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}
