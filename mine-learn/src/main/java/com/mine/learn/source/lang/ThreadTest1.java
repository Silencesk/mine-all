package com.mine.learn.source.lang;

public class ThreadTest1 {
    public static Object object = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        System.err.println(thread1 + ":" + thread1.getState().name());
        thread1.start();
        System.err.println(thread1 + ":" + thread1.getState().name());

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.err.println(thread2 + ":" + thread2.getState().name());
        System.err.println(thread1 + ":" + thread1.getState().name());
        thread2.start();
        System.err.println(thread2 + ":" + thread2.getState().name());
        System.err.println(thread1 + ":" + thread1.getState().name());
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                try {
                    Thread.currentThread().sleep(100000);
                    // 线程TIMED_WAITING
                    object.wait(100000);
                    // 线程WAITING
                    object.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            // 同时竞争锁的情况下，未成功获取锁的线程将进入BLOCKED状态
            synchronized (object) {
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用了object.notify()");
            }
            System.out.println("线程" + Thread.currentThread().getName() + "释放了锁");
        }
    }
}