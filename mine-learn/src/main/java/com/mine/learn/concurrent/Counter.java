package com.mine.learn.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 *  see http://www.cnblogs.com/aigongsi/archive/2012/04/01/2429166.html
 */
public class Counter {

    /**
     * 用volatile修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。
     * volatile很容易被误用，用来进行原子性操作。
     * volatile并不能解决并发问题，可以尝试使用AtomicLong代替，只能使用synchronized处理
     */
    public volatile static int count = 0;
    /**
     * 使用AtomicLong可以处理并发，因其是原子性操作
     */
    public static AtomicLong count1 = new AtomicLong();
    /**
     * 线程数
     */
    public static final int threadCount = 1000;
    /**
     * 主线程等待子线程的完成，就不用使用线程join了，编码简单些
      */
    public static CountDownLatch countDownLatch = new CountDownLatch(threadCount);


    public static void inc() {
 
        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
 
        count++;
//        count1.incrementAndGet();
    }
 
    public static void main2(String[] args) {
 
        //同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                    countDownLatch.countDown();
                }
            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + Counter.count);
        System.out.println("运行结果:Counter.count1=" + Counter.count1);
    }

    public static void main1(String[] args) {

        //同时启动1000个线程，去进行i++计算，看看实际结果
        Thread[] tasks = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            tasks[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            });
            tasks[i].start();
            //在for循环中的join相当于线程的顺序执行
//                tasks[i].join();
        }

        // 需独立开启for循环join，这样才是并发执行
        try {
            for (Thread task : tasks) {
                task.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + Counter.count);
        System.out.println("运行结果:Counter.count1=" + Counter.count1);
    }
}