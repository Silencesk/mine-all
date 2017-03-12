# 故障排除
## java application===>莫名其妙的找不到或无法加载启动类
* 将原有项目从eclipse中删除，重新import
* target文件被清除，需重新生成，使用`mvn clean install`

## feign调用404错误
* 检查调用的输入参数是否非空，如果参数为空，则会调用参数为空的controller方法
* 检查调用的输入参数类型是否与controller对应的类型一致，若不一致也会报404
* feign调试关键代码  

````java
INFO 8044 --- [io-20095-exec-1] c.n.l.DynamicServerListLoadBalancer      : DynamicServerListLoadBalancer for client bf-mdm-api initialized: DynamicServerListLoadBalancer:{NFLoadBalancer:name=xxx_app,current list of Servers=[172.20.32.126:20031],Load balancer stats=Zone stats: {defaultzone=[Zone:defaultzone;        Instance count:1;        Active connections count: 0;        Circuit breaker tripped count: 0;        Active connections per server: 0.0;]
},Server stats: [[Server:172.20.32.126:20031;        Zone:defaultZone;        Total Requests:0;        Successive connection failure:0;        Total blackout seconds:0;        Last connection made:Thu Jan 01 08:00:00 CST 1970;        First connection made: Thu Jan 01 08:00:00 CST 1970;        Active Connections:0;        total failure count in last (1000) msecs:0;        average resp time:0.0;        90 percentile resp time:0.0;        95 percentile resp time:0.0;        min resp time:0.0;        max resp time:0.0;        stddev resp time:0.0]
]}ServerList:org.springframework.cloud.netflix.ribbon.eureka.DomainExtractingServerList@38f6beb

类 SynchronousMethodHandler** 97行
response = client.execute(request, options);
````

## service类中的@Sheduled,@Async注解无法生效
* 定义service包中的service类对应方法上的@Sheduled,@Async注解无效，因service类是有应用事务切面的。  
* 在扫描注解时获取target类时并未获取到实际类，还是代理后的类，故无法扫描到注解的。
* 该问题的原因在于service类存在多切面代理：事务管理切面，以及shiro方法级权限控制切面。导致扫描spring自带的这些注解时，无法得到原始类

## 启动类上使用@EnAync注解后，报错
使用spring异步机制时，启动类上使用@EnAync注解后，启动类会报循环依赖错误。

````
There is a circular dependency between 1 beans in the application context:
	- menuController (field com.eyd.uc.core.service.menu.MenuService MenuController.service)
	- menuService

````
@Async无法作用于抽象类上，改为实际类上后就没有问题了。


## maven-replace-plugin $ 特殊符号处理
在$前加上转义符\，参考[Maven replacer: replacement value containing dollar signs](http://stackoverflow.com/questions/33667378/maven-replacer-replacement-value-containing-dollar-signs)

````
\${basePath}/static/js/${web.project.js.base.name}.js
````

## 关于jar包中类重写问题
当发现某些jar包中的类存在bug，或者需要增加额外逻辑的时候，需要重写该类。那主要有如下几种方式：
*

## @Sheduled即使没有在使用@EnableScheduling情况下也会生效
* 因程序中使用了@EnableAsync，便会创建线程池，默认情况下@Sheduled与@Async任务使用同一线程池。
* 同时把@EnableAsync @EnableScheduling去除就对了
* 只要存在线程池，则都会有效，比如@EnableWebSocketMessageBroker  
========以上结论不正确，原因待查明=========  


## @Async, @Sheduled, InheritableThreadLocal冲突
应用程序中存在定时任务@Sheduled, 在执行@Async异步方法中，InheritableThreadLocal变量无法获取主本地线程ThreadLocal中的变量
* 因存在@Sheduled任务时，spring会开启线程池管理，而@Async执行的异步任务时，其线程也是从Scheduled任务线程池中获取的线程。
* 故尽管使用了InheritableThreadLocal，但却无法从主线程中传递该本地线程变量，具体执行异步任务的线程与主线程是没有关系的
* 可考虑为@Async异步任务专门指定异步任务线程池，与@Sheduled调度任务线程池分离，应该可以解决此问题
*

## 3.0应用程序很吃内存问题
* spring boot应用程序内存优化
https://segmentfault.com/a/1190000004252885  
https://dzone.com/articles/spring-boot-memory-performance  
http://www.alexecollins.com/spring-boot-performance/  
https://cloud.google.com/appengine/articles/spring_optimization  
* 容器编排，内存设置  
http://blog.csdn.net/kimylrong/article/details/52448589
* 设置docker容器所使用的最大内存
* 设置应用程序所能使用的最大运行内存与初始值, jvm调优
```
java -Xms512m -Xmx2g -jar target/xxx_app.jar --config.profile=mine
```

##  markdown内联元素支持不友好
内联元素无法支持大写字母以及`.`等特殊字符  
支持的格式为纯小写字母，纯中文，对于空格可以用`-`代替

## 应用程序响应慢，出现假死现象
 * 水平扩容，堆机器
 * 调优tomcat，主要参数，最大连接数setMaxConnections，最大线程数MaxThreads
 http://www.cnblogs.com/softidea/p/5751596.html

## mysql查询不区分大小写
ALTER TABLE uc_user CONVERT TO CHARACTER SET utf8 COLLATE utf8_bin;  
用这个更新下表的字符校验
