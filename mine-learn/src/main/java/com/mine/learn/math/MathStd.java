package com.mine.learn.math;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 数学计算
 *
 * @author liutao
 * @create 2017-02-28 下午3:25
 */

public class MathStd {

    /**
     * 除法测试
     */
    @Test
    public void divide() {
        long l1 = 1L;
        int l2 = 1000;
        long l3 = 1000L;
        BigDecimal bg1 = new BigDecimal(l1);
        BigDecimal bg2 = new BigDecimal(l2);
        System.out.println(l1 / l2);  // 0
        System.out.println(l1 / l3);  // 0
        System.out.println(bg1.divide(bg2, 3, BigDecimal.ROUND_UP));  // 0.001
        System.out.println((double) l1 / l2);  // 0.001 强制转换为double可得到小数部分
    }

    @Test
    public void powerOfTwo() {
//        System.err.println(Math.pow(2, 20));
        for (int i = 1; i <= 10; i++) {
            System.err.println("2^" + (10 + i));
            System.err.println(1024 * Math.pow(2, i));
        }
    }
}
