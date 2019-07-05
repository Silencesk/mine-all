package com.mine.learn.source.lang;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleThreadFactory implements ThreadFactory {
    private AtomicInteger currentSeq = new AtomicInteger(0);
    private static final String MY_THREAD_PREFIX = "lt-thread-";

    @Override
    public Thread newThread(Runnable r) {
        String name = MY_THREAD_PREFIX + currentSeq.addAndGet(1);
        Thread thread = new Thread(r);
        thread.setName(name);

        return thread;
    }
}
