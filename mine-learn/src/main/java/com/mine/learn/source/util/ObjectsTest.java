package com.mine.learn.source.util;

import java.util.Objects;

import org.junit.Test;

/**
 * ObjectsTest
 *
 * @author liutao
 * @version 2018-07-25 下午10:15
 */

public class ObjectsTest {

    @Test
    public void testRequireNoneNull() {
        // 用于参数校验，if null，throw NPE
        Objects.requireNonNull(null);

    }
}
