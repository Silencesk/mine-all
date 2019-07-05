package com.mine.learn.source.lang;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private static final int MAX_LOOP_SIZE = 10000;
    private static final int THREAD_SIZE = 4;
    private static final int WAITING = 1000;
    private Lock lock = new ReentrantLock();
    private String hold = "false";

    public static void main(String[] args) throws Exception {
        ThreadTest test = new ThreadTest();
        test.testLockState();
    }

    private void testLockState() {
        ThreadFactory threadFactory = new SimpleThreadFactory();
        List<Thread> threads = Lists.newArrayList();
        for (int i = 0; i < THREAD_SIZE; i++) {
            Thread thread = threadFactory.newThread(() -> doLockState());
            threads.add(thread);
        }
        threads.forEach(Thread::start);
        printMultipleThreadState(threads);
    }

    private void doLockState1() {
        try {
            System.err.println(getThreadDetail());
            lock.lock();
            if (Thread.currentThread().getName().equals("lt-thread-4")) {
                lock.notifyAll();
            } else {
                lock.wait();
            }
//            Thread.sleep(10);
            System.err.println(getThreadDetail());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void doLockState() {
        System.err.println(getThreadDetail());
        synchronized (hold) {
            try {
                Thread.sleep(WAITING);
                if (Thread.currentThread().getName().equals("lt-thread-4")) {
                    hold.notifyAll();
                } else {
                    hold.wait(WAITING);
                }
                System.err.println(getThreadDetail());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String getThreadDetail() {
        return getThreadDetail(Thread.currentThread());
    }

    private String getThreadDetail(Thread thread) {
        return thread.getName() + ":" + Thread.currentThread().getState().name();
    }

    private void testGeneralState() {
        Thread thread = new Thread("t-state") {
            @Override
            public void run() {
                System.err.println("run ......");
                System.err.println(Thread.currentThread().getState());
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("run end ....");
            }
        };
        System.err.println(thread.getState());
        thread.start();
        printThreadState(thread);
    }

    private void printThreadState(Thread thread) {
        int i = 0;
        while (i++ < MAX_LOOP_SIZE) {
            System.err.println(thread.getState());
        }
    }

    private void printMultipleThreadState(List<Thread> threads) {
        while (true) {
            threads.forEach(x -> System.err.println("thread state scan:" + getThreadDetail(x)));
        }
    }



}
