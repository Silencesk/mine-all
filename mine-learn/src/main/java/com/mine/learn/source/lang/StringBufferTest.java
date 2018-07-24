package com.mine.learn.source.lang;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.google.common.collect.Lists;

import lombok.SneakyThrows;


/**
 * StringBuilder
 *
 * @author liutao
 * @create 2018-03-04 下午2:40
 */

public class StringBufferTest {

    static final int MAX = 1000;
    static CountDownLatch latch;

    public static void main(String[] args) throws InterruptedException {
        /**
         * 验证StringBuffer与StringBuilder的线程安全
         * 还有个更简便的验证方法{https://blog.csdn.net/banjuer/article/details/52068702}
         */
        assertAppendCorrect(new StringBuffer(100));
        assertAppendCorrect(new StringBuilder(100));
    }

    @SneakyThrows
    public static void assertAppendCorrect(CharSequence sequence) {
        // 使用CountDownLatch方式来保证子线程的完成
//        latch = new CountDownLatch(MAX);
        String name = (sequence instanceof StringBuffer) ? "StringBuffer" : "StringBuilder";
        System.out.println(name + " start...");
        List<Thread> threads = appendByConcurrent((Appendable) sequence);
        // 采用join的方式实现主线程等待子线程的完成
        threads.forEach(x -> {
            try {
                x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        latch.await();
        assertEquals(MAX * 5, sequence.length());
        System.out.println(name + " end...");
    }

    public static List<Thread> appendByConcurrent(Appendable appendable) {
        List<Thread> threads = Lists.newArrayList();
        for (int i = 0; i < MAX; i++) {
            // 只取0-9的一位数字，便于后面的求和
            String s = "" + (i % 10);
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronizedAppend(appendable, s);
                latch.countDown();
            };
            // 如果只是runnable的list，并进行run，程序并没有以多线程的方式运行，还是一个线程
            // 只有new Thread之后，并且start，才相当于多线程运行
            threads.add(new Thread(runnable));
        }
        // 非多线程，只是单纯的run
//        threads.forEach(x -> x.run());
        // 多线程，start表示开启
        threads.forEach(x -> x.start());

        return threads;
    }

    @SneakyThrows
    public static void synchronizedAppend(Appendable appendable, String s) {
        for (int i = 0; i < 5; i++) {
            appendable.append(s);
        }
    }
}
