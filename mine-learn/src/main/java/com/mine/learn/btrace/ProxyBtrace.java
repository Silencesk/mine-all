package com.mine.learn.btrace;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.println;

/**
 * 代理类的btrace
 */
@BTrace
public class ProxyBtrace {
  // 版本修改
//  static {
//    println("1");
//  }

    //监控某一个方法的执行时间
    @OnMethod(clazz = "com.mine.learn.xk.OurStoryController", method = "firstChat",location=@Location(Kind.RETURN))
    public static void printMethodRunTime(@ProbeClassName String probeClassName,@Duration long duration){
        println(probeClassName + ",duration:" + duration / 1000000 + " ms");
    }
}
