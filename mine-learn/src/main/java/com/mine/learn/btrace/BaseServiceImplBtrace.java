package com.mine.learn.btrace;

import com.sun.btrace.annotations.*;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class BaseServiceImplBtrace{

    // 监控某一个方法的执行时间
    @OnMethod(clazz = "+com.belle.common.service.BaseServiceImpl",method = "findAll",location=@Location(Kind.RETURN))
	//@OnMethod(clazz = "/com.belle.common.service.*/",method = "findAll",location=@Location(Kind.RETURN))
    public static void printMethodRunTime(@ProbeClassName String probeClassName,@Duration long duration){
        // output: version 1, com.belle.common.service.BaseServiceImpl,duration:30 ms
		println("version 1, " + probeClassName + ", duration:" + duration / 1000000 + " ms");
    }
}
