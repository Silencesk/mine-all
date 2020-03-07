package com.mine.learn.thread;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {
    private static final int MAX_SIZE = 1000;

    public static void main(String[] args) {
        /**
         * 公共的forJoin线程池
         * 并发线程数默认为cpu核心数-1
          */
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.println("submit start....." + i);
            forkJoinPool.submit(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println(Thread.currentThread() + ".....");
            });
            System.out.println("submit end....." + i);
        }
        System.err.println(JSON.toJSONString(forkJoinPool));
        System.err.println("cup cores " + Runtime.getRuntime().availableProcessors());
    }
}
