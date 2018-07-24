package com.mine.core.util;

import java.util.Map;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

/**
 * OS操作系统相关工具类
 *
 * @author liutao
 * @since 2017-05-12 上午10:01
 */
@Slf4j
public class OSUtils {

    private OSUtils() {
    }

    public static OSEnum getCurrentOS() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf("window") >= 0) {
            return OSEnum.WINDOWS;
        } else {
            return OSEnum.LINUX;
        }
    }

    public static void printSystemProperties() {
        Properties p = System.getProperties();
        for (Map.Entry entry : p.entrySet()) {
            log.info(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static String getUserHomeDir() {
        Properties p = System.getProperties();
        return p.getProperty("user.home");
    }

    public static String getUserName() {
        Properties p = System.getProperties();
        return p.getProperty("user.name");
    }

    public enum OSEnum {
        WINDOWS("windows"), LINUX("linux");

        private String value;

        OSEnum(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        printSystemProperties();
    }
}
