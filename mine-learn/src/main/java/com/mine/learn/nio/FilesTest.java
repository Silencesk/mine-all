package com.mine.learn.nio;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class FilesTest {

    @Test
    @SneakyThrows
    public void test() {
        Map<String, Object> attributes = Files.readAttributes(Paths.get("/Users/mokeo/Coder/0-mine/mine-all/mine-learn/src/main/java/com/mine/learn/nio/FilesTest.java"), "*");
        // 无法获取字符编码
        System.err.println(JSON.toJSONString(attributes));
    }
}
