package com.mine.learn.source.lang;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mine.core.util.ReflectUtils;

/**
 * StringBuilder
 *
 * @author liutao
 * @create 2018-03-04 下午2:40
 */

public class StringBuilderTest {

    @Test
    public void testDefaultChar() {
        StringBuilder sb = new StringBuilder(4);
        sb.append("lt");
        Object valueObj = ReflectUtils.invokeMethodByName(sb, "getValue", null);
        assertTrue(valueObj.getClass().isArray());
        char[] value = (char[]) valueObj;
        for (int i = 0; i < sb.length(); i++) {
            // StringBuilder的实际字符长度length与容量capacity，大于length的部分都是用空字符'\0'填充的
            assertEquals(value[sb.length()], '\0');
        }

        StringBuilder sb1 = new StringBuilder();
        assertEquals(sb1.capacity(), 16);
    }

    @Test
    public void testCapacity() {
        int capacity = 4;
        StringBuilder sb = new StringBuilder(capacity);
        sb.append("lt");
        sb.append("moke");
        assertEquals(sb.capacity(), capacity * 2 + 2);
        // 若直接使用字符串的构造函数，其初始容量为字符串长度+16
        sb = new StringBuilder("moke");
        assertEquals(sb.capacity(), 20);
    }

    @Test
    public void testReverse() {
        StringBuilder sb = new StringBuilder(StringTest.MOKE);
        assertEquals(sb.reverse().toString(), "ekom");
    }
}
