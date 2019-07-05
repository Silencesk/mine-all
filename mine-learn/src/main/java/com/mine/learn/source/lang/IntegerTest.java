package com.mine.learn.source.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class IntegerTest {

    @Test
    public void test() {
        Integer num = new Integer(4);
        try {
            num.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(num == 4);
        num = 1;
        Assert.assertTrue(num == 1);
        Integer num1 = null;
        Assert.assertFalse(Objects.equals(num1, 1));
        Integer c = 1 + 2;
        Assert.assertTrue(c == 3);
    }
}
