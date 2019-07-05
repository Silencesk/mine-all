package com.mine.learn.util;

import com.mine.learn.algorithm.LRUCache;
import org.junit.Test;

import java.util.*;

public class LinkedHashMapTest {

    @Test
    public void testLimitMaxSize() {
        int maxSize = 4;
        Map<String, String> data = new LinkedHashMap<String, String>(3, 0.75f, true) {

            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > maxSize;
            }
        };
        data.put("1", "a");
        data.put("2", "b");
        data.put("3", "c");
        data.put("4", "d");
        data.put("5", "e");

        data.get("1");
        data.get("2");

        data.put("6", "f");
        data.put("7", "g");

//        data.get("3");
//        data.get("5");

        accessAndPrint(data);
    }

    @Test
    public void test() {
        Map<String, String> map = new LinkedHashMap<String, String>(16, 0.75f, true);
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "e");

        // new add
        map.get("1");
        map.get("2");

        accessAndPrint(map);
    }

    @Test
    public void testCache() {
        Map<String, String> cache = new LRUCache<>(4);
        cache.put("one", "1");
        cache.put("two", "2");
        cache.put("three", "3");

        accessAndPrint(cache);

        cache.get("one");
        cache.get("two");

        accessAndPrint(cache);
    }

    private void accessAndPrint(Map<String, String> map) {
        System.err.println("-------------------");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.err.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
