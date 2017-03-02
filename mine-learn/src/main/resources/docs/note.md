## 手工编译jar包
* 源码文件HelloWorld.java
```java
package com.mine.learn;
public class HelloWorld {

    public static void main( String[] args )
    {
        String intput = "Hello World!";
        System.out.println(intput);
    }
}
```

* 进入到HelloWorld所在目录
* 编译HelloWorld.class文件
```
javac HelloWorld.java
```

* 生成helloworld.jar
```
-- 存在包名
1.则先进入到所在包的根目录
2.生成jar包，语法参考 http://docs.oracle.com/javase/7/docs/technotes/tools/windows/jar.html
  jar -cfe hellworld.jar com.mine.learn.HelloWorld com/mine/learn/HelloWorld.class  
3.执行jar文件
  java -jar helloworld.jar
-- 不存在包名
jar cfe hellworld.jar HelloWorld HelloWorld.class
java -jar helloworld.jar
```
* 参考：  
[office](http://docs.oracle.com/javase/7/docs/technotes/tools/windows/jar.html)
[手动编译含package的java源程序(包含外部包中定义的类)](http://www.cnblogs.com/lz3018/p/5227502.html)  

## jstack分析最耗cpu的线程，并定位代码
* 编写死循环代码，用于模拟cpu高利用率场景
```java
public class TraceHighIOStd {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread());
                }
            }
        });
        thread.start();
    }
}
```
* 在服务器上运行该代码
* 使用top命令查看cpu消耗高的进程pid，`top 界面，输入大写P，按cpu使用排序`，此处结果`8058`  
[jstack-1.png](../images/jstack-1.png)
* 得到进程pid下cpu消耗最大的线程tid， `ps p 8058 -L -o pcpu,pid,tid,time,tname,cmd`，此处结果`8074`  
[jstack-2.png](../images/jstack-2.png)
* 得到线程tid的16进制数据nid `printf "%x\n" 8074`，此处结果`1f8a`  
[jstack-3.png](../images/jstack-3.png)
* 使用jstack查看进程pid堆栈内容 `jstack -l 8058`
[jstack-4.png](../images/jstack-4.png)
* 在堆栈内容中找到前面查找出的nid的信息处，可直接定位到源码行
* 参考：  
[高手是怎么使用jstack精确找到异常代码的](http://jingyan.baidu.com/album/4f34706e3ec075e387b56df2.html)
[JVM调优之jstack找出最耗cpu的线程并定位代码](http://www.cnblogs.com/chengJAVA/p/5821218.html)

## 