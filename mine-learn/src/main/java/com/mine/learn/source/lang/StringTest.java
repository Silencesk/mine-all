package com.mine.learn.source.lang;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * String
 *
 * @author liutao
 * @create 2018-03-04 下午1:14
 */

public class StringTest {

    public static String MOKE = "moke";
    private static String str = "play hard, work smart";
    private static String str1 = "play hard2, work smart";

    @Test
    public void testStringOf() {
        Integer i = Integer.valueOf(10);
        String s = String.valueOf(i);
        assertEquals(s, i.toString());
    }

    @Test
    public void testSplit() {
        StringBuilder sb = new StringBuilder(100);
        Random random = new Random(100);
        int max = 100;
        for (int i = 0; i < max; i++) {
            sb.append(",").append(random.nextInt());
        }
        int limit = 200;
        int len1 = sb.substring(1).split(",").length;
        // 对于只取分割数组中，特定位数的，就可以用limit，提高效率
        int len2 = sb.substring(1).split(",", limit).length;
        assertEquals(len1, max);
        assertEquals(len2, limit > max ? max : limit);
    }

    @Test
    public void testIntern() {
        // 常量池中的对象
        String s1 = "aaa";
        // 堆中的对象
        String s2 = new String("aaa");
        assertFalse(s1 == s2);
        // 如果常量池中存在字符串，则直接返回在常量池的引用；
        // 否则会先在常量池中创建一个值相等的对象，并返回该对象的引用
        s2.intern();
        assertFalse(s1 == s2);
        s2 = s2.intern();
        assertTrue(s1 == s2);

        Integer[] ints = new Integer[10];
        Random random = new Random(10 * 1000);
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt();
            System.err.println(ints[i]);
        }
        int MAX = 10000000;
        long start = System.currentTimeMillis();
        String[] arr = new String[MAX];
        for (int i = 0; i < MAX; i++) {
            // 1
            arr[i] = new String(String.valueOf(i % ints.length));
            // 2
//            arr[i] = new String(String.valueOf(i%ints.length)).intern();
        }
        // 1-10428ms; 2-3236ms
        System.err.println("cost is " + (System.currentTimeMillis() - start) + "ms");
    }

    @Test
    public void testInit() {
        String s = new String();
        assertTrue("".equals(s));
        assertFalse(s == null);
    }

    @Test
    public void testCharArrayValue() {
        char[] value = {'a', 'b'};
        char value2[] = {'a', 'b'};
        System.err.println(value);
        System.err.println(value2);
        assertNotEquals(value, value2);
        // 字符数组的toString是返回的对象的地址；如果是对象或数组，toString返回的当然是引用地址
        System.err.println("char array toString: " + value.toString());
        assertNotEquals(value.toString(), value2.toString());
        assertTrue(Arrays.equals(value, value2));
    }

    @Test
    public void testCodePoints() {
        // codePoints返回的仍然为字符对应的ascii码，10进制整数
        System.err.println("codePoints()......");
        str.codePoints().forEach(System.out::println);
        System.err.println("codePoints.equals(chars)......");
        List<Integer> codePoints = str.codePoints().boxed().collect(Collectors.toList());
        List<Integer> chars = str1.chars().boxed().collect(Collectors.toList());
        System.out.println(codePoints.equals(chars));
    }

    @Test
    public void testChars() {
        System.err.println("chars()......");
        str.chars().forEach(System.out::println);
    }

    @Test
    public void testCharAt() {
        System.err.println("testCharAt()......");
        for (int i = 0; i < str.length(); i++) {
            System.out.println(String.format("%d:%s", Integer.valueOf(str.charAt(i)), str.charAt(i)));
        }
    }

    @Test
    public void test() {
        int len = str.length();
        System.out.println(len);
        // 扩大1倍
        System.out.println(len << 1);
        // 扩大2倍
        System.out.println(len << 2);
        // 缩小2倍
        System.out.println(len >> 2);
        assertEquals(len >> 2, len / 4);
        assertEquals(len << 1, len * 2);
    }
}
