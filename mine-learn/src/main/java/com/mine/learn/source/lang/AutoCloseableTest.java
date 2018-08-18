package com.mine.learn.source.lang;

import org.junit.Test;

/**
 * AutoCloseableTest
 *
 * @author liutao
 * @version 2018-07-25 下午10:57
 */

public class AutoCloseableTest {

    @Test
    public void testClose() {
        // try-with-resources语法只在try范围内生效
        // 可以看编译后的class文件，有利于理解其方法
        try(MyAutoCloseable closeable = new MyAutoCloseable()) {
            System.err.println("enter try....");
            System.err.println("resources length: " + closeable.resources.length);
            throw new RuntimeException("close() will before catch");
        } catch (Exception e) {
            System.err.println("enter catch....");
            // catch中已经无法获取到closeable，在catch之前就已经被处理掉了
            e.printStackTrace();
        }
    }

    class MyAutoCloseable implements AutoCloseable {
        String[] resources = new String[10];

        @Override
        public void close() throws Exception {
            System.err.println("close was called....");
            if (resources == null) {
                return;
            }
            resources = null;
        }
    }
}
