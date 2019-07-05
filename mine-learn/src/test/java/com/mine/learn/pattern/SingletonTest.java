package com.mine.learn.pattern;

import com.mine.learn.pattern.singleton.Singleton;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class SingletonTest {


    @Test
    public void test () {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }

    /**
     * 通过反射创建单例
     */
    @Test
    @SneakyThrows
    public void testCreateByReflect() {
        Singleton instance = Singleton.getInstance();
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor(new Class<?>[0]);
        constructor.setAccessible(true);
        Singleton instanceReflected = constructor.newInstance();
        Assert.assertEquals(instance, instanceReflected);
    }
}
