package com.sykent.provier;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Sykent.Lao e-mail:sykent.lao@gmail.com blog:https://sykent.github.io/
 * @version 1.0
 * @since 2020/05/18
 */
public class Provier {
    private ArrayBlockingQueue<Object> mDeque = new ArrayBlockingQueue<Object>(3);
    private Thread mProviderThread;
    private Thread mComsumeThread;
    private volatile boolean isStop = false;

    public Provier() {

        mProviderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isStop) {
                    try {
                        mDeque.put(new Object());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        mComsumeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isStop) {
                    try {
                        Object obj = mDeque.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        mProviderThread.start();
        mComsumeThread.start();
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }
}
