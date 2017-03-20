package com.mine.learn.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.println;

@BTrace
public class BasSupplierServiceImplBtrace{
	
	// 打印内容
    @OnMethod(clazz = "/com.belle.srm.service.bas.impl.BasSupplierServiceImpl.*/",method = "findAll",location=@Location(Kind.RETURN))
    public static void trace(@ProbeClassName String probeClassName,@Duration long duration, @Self Object self, @Return AnyType result){
		println("version 3, " + probeClassName + ", duration:" + duration / 1000000 + " ms");
		println("version 3, self=" + self + ", result=" + result);
    }
	
	// 对于代理类的监控，需要使用正则或者直接使用代理类class
	@OnMethod(clazz = "/com.belle.srm.service.bas.impl.BasSupplierServiceImpl.*/",method = "findAll",location=@Location(Kind.RETURN))
	//@OnMethod(clazz = "com.belle.srm.service.bas.impl.BasSupplierServiceImpl$$EnhancerBySpringCGLIB$$9a91ba07",method = "findAll",location=@Location(Kind.RETURN))
    public static void printMethodRunTime(@ProbeClassName String probeClassName,@Duration long duration){
        // output: version 4, com.belle.srm.service.bas.impl.BasSupplierServiceImpl$$EnhancerBySpringCGLIB$$9a91ba07, duration:37 ms
		println("version 4, " + probeClassName + ", duration:" + duration / 1000000 + " ms");
    }
	
	 // 监控BasSupplierServiceImpl所在包
    // @OnMethod(clazz = "/com.belle.srm.service.bas.impl.*/",method = "findAll",location=@Location(Kind.RETURN))
    // public static void printMethodRunTime(@ProbeClassName String probeClassName,@Duration long duration){
        // output: version 3, com.belle.srm.service.bas.impl.BasSupplierServiceImpl$$EnhancerBySpringCGLIB$$9a91ba07, duration:37 ms
		//println("version 3, " + probeClassName + ", duration:" + duration / 1000000 + " ms");
    //}
}
 