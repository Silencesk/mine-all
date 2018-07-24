package com.mine.learn.jvm.oom;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.common.collect.Lists;

/**
 * 堆内存溢出
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author liutao
 * @create 2018-01-21 上午10:49
 */

public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        Properties p = System.getProperties();
        for(Map.Entry entry: p.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        List<OOMObject> list = Lists.newArrayList();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
