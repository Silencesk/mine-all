package com.mine.learn.btrace;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class CheckOnlineStatus{
  //print System Properties:
  static {
    println("System Properties:");
    printProperties();
    println("VM Flags:");
    printVmArguments();
    println("OS Enviroment:");
    printEnv();
    // exit(0);
  }

    //监控某一个方法的执行时间
    @OnMethod(clazz = "com.euond.uc.service.rightlist.RightListService",method = "find",location=@Location(Kind.RETURN))
    public static void printMethodRunTime(@ProbeClassName String probeClassName,@Duration long duration){
        println(probeClassName + ",duration:" + duration / 1000000 + " ms");
    }
}
