package com.mine.learn.pattern.singleton;


public class SingletonCase {
    private static volatile SingletonCase instance;

    private SingletonCase() {
    }

    public static SingletonCase getInstance() {
        if (instance == null) {
            synchronized (SingletonCase.class) {
                if (instance == null) {
                    instance = new SingletonCase();
                }
            }
        }

        return instance;
    }
}
