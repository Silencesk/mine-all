package com.mine.learn.pattern.singleton;

public class DbLockCheckSingletion {
    private volatile DbLockCheckSingletion instance;

    public DbLockCheckSingletion getInstance() {
        if (instance == null) {
            synchronized (DbLockCheckSingletion.class) {
                if (instance ==  null) {
                    instance = new DbLockCheckSingletion();
                }
            }
        }

        return instance;
    }

}
