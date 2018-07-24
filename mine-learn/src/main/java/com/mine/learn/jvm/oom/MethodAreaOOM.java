package com.mine.learn.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * 方法区内存溢出
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M 该参数在java8中已失效
 * => VM Args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * @see <a>https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html</a>
 * @author liutao
 * @create 2018-01-21 下午11:05
 */

public class MethodAreaOOM {
    static int TIMES_OF_WHILE = 0;

    public static void main(String[] args) {
        while (true) {
            TIMES_OF_WHILE ++;
            try {
                createProxy();
            } catch (Throwable e) {
                System.err.println("TIMES_OF_WHILE is " + TIMES_OF_WHILE);
                throw e;
            }
        }
    }

    static void createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OOMObject.class);
        enhancer.setUseCache(false);
        MethodInterceptor methodInterceptor = (o, method, objects, methodProxy) -> null;
        enhancer.setCallback(methodInterceptor);
        enhancer.create();
    }

    static class OOMObject {

    }
}
