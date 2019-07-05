package com.mine.learn.pattern.singleton;

/**
 * Description: 惰性初始化的单例设计模式
 * Java中静态内部类可以访问其外部类的成员属性和方法，
 * 同时，静态内部类只有当被调用的时候才开始首次被加载，
 * 利用此特性，可以实现懒汉式，在静态内部类中静态初始化外部类的单一实例即可
 * 线程安全
 * 静态内部类&&静态代码块，都是在这个类第一次被调用或实例化的时候就会被执行。
 */
public class Singleton {
    private static int count = 0;

    /**
     * 定义私有方法 不能通过默认的构造器获取对象
     */
    private Singleton() {
        System.out.println("constructor singleton ....");
        synchronized (Singleton.class) {
            if (count >= 1) {
                throw new IllegalStateException("singleton already have instance");
            }
        }
        count++;
    }

    /**
     * 定义静态内部类，持有对象instance，单例缓存者，实现惰性初始化，第一次使用的时候初始化
     */
    public static class SingletonHolder {
        public static final Singleton INSTANCE = new Singleton();

        static {
            System.out.println("SingletonHolder static block");
        }
    }

    /**
     * 提供获取单例的全局访问点
     */
    public static Singleton getInstance() {
        System.err.println("singleton get instance");
        return SingletonHolder.INSTANCE;
    }
}
