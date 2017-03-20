package com.mine.learn.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.println;

/**
 * filter btrace
 */

//@BTrace(unsafe = true)
@BTrace
public class ShiroCasFilterBtrace {
	// btrace是否生效
	static {
		println("btrace success");
	}
	
	// 打印每个请求url，以及耗时
	@OnMethod(clazz = "com.belle.common.web.shiro.ShiroCasFilter", method = "doFilter",location=@Location(Kind.RETURN))
    public static void trace(@ProbeClassName String probeClassName, @Duration long duration, @Self Object self, AnyType param1, javax.servlet.ServletRequest request){
		println("version 1, " + probeClassName + ", requestUrl:"
				//+ ((javax.servlet.http.HttpServletRequest)request).getRequestURI()
				+ request
				+ ", duration:" + duration / 1000000 + " ms");
    }

}
 