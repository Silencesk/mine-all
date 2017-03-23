package com.mine.learn.hardware;

import org.junit.Test;

/**
 * @author liutao
 * @create 2017-03-23 下午2:17
 */

public class HardwareStd {

    @Test
    public void getCpuNumber(){
        int num = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu number is " + num);
    }
}
