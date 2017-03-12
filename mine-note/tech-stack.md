# 技术栈
所用技术栈
* [feign](#feign)
* [docker](#docker)
* [docker-maven-plugin](#docker-maven-plugin)
* [markdown](#markdown)
* [spring boot admin](#spring-boot-admin)
* [spring cloud config](#spring-cloud-config)
* [spring boot](#spring-boot)
* [etcd](#etcd)
* [kubernetes](#kubernetes)
* [swagger](#swagger)
* [zipkin](#swagger)
* [gradle](#gradle)
* [hibernate](#hibernate)

## feign
netflix方便http调用的组件，可以有本地调用效果。
1. `@FeignClient`定义的接口，也会作为应用程序暴露的web接口，相当于`@Controller`定义的接口。在浏览器端需完全匹配的形式请求，否则不能正确响应。
2. 客户端的负载均衡可使用`@RibbonClient`注解。`@EnableFeignClients`自带客户端负载均衡。
3. feign接口中的参数名若未标识`@RequestParam`，则默认为`@RequestBody`。尽管方法上面定义的请求类型为get，但只要未设置`@RequestParam`，实际请求也会为post。
* feign接口与接口服务需要使用注解与未使用注解要保持一致，否则会出现转换问题
4. [使用Spring Cloud Feign作为HTTP客户端调用远程HTTP服务](http://blog.csdn.net/neosmith/article/details/52449921)
5. [关于使用feign调用异常处理参考](http://www.cnblogs.com/yish/p/5850813.html)
* feign定义的接口中，在接口类与方法上面添加`@RequestMapping`，以使用组合映射。这种方式的配置，与hystrix一起使用的时候，会报requestmapping重复，因spring mvc中不能存在多个bean对应同一requestmapping，但只是定义在方法上是没问题的。
* feign定义的接口，如果使用注解@component
*

## docker
docker容器
1. 查看docker所有运行的容器`docker ps`；根据关键字查看docker运行容器`docker ps -a|grep eyd`
2. 删除镜像`docker rmi [imageId]`；若镜像在运行则需要先删掉镜像运行的容器，`docker rm [containName]`
3. 查看docker镜像 `docker images`
4. 运行docker镜像，以eyd-register-center为例
  * 当前命令窗口启动，`docker run -p 10021:10021` ，ctr+c则会关闭运行
  * 后台守护进程启动，`docker run --name register-center -d -p 10021:10021 ip_addr:5000/eyd/eyd-register-center`
5. 查看日志
  * `docker ps -a`
  * `docker logs -f $CONTAINER_ID` #查看docker实例运行日志，即时输出
  * **docker logs -f \`docker ps -a|grep register-center|awk '{if($11 != "grep") {print $1}}'\`** #一步根据关键字查看即时输出日志，其中register-center为关键字
6. **docker rm \`docker ps -a | grep Exited | awk '{print $1}'\`** #删除已退出的所有容器
* 进入容器内部`docker exec -it [containerid] /bin/bash`
* copy容器内部文件`docker cp [containerid]:/app.jar .` [参考](http://blog.csdn.net/yangzhenping/article/details/43667785)

## docker-maven-plugin
打包docker镜像的maven插件
1. 打包镜像 `mvn clean package -Dmaven.test.skip=true -U docker:build`
2. 打包镜像并上传docker私服 `mvn clean package -Dmaven.test.skip=true -U docker:build -DpushImage`
3. 打包镜像并将指定tag上传docker私服 `mvn clean package -Dmaven.test.skip=true -U docker:build -DpushImageTags -DdockerImageTag=latest` 未验证通过
4. others
  * set DOCKER_HOST=tcp://ip_addr:2375
5. problem
  * `Dockfile`中添加的jar包会带上版本，当应用程序版本进行变更的时候，也需要修改`Dockfile`文件
6. 相关资料
  * [docker-maven-plugin](https://github.com/spotify/docker-maven-plugin)
  * [持续集成案例学习：Docker、Java与Maven](http://www.open-open.com/lib/view/open1439793616442.html)
  * [使用Maven插件构建Docker镜像](https://git.oschina.net/itmuch/spring-cloud-book/blob/master/3%20%E4%BD%BF%E7%94%A8Docker%E6%9E%84%E5%BB%BA%E5%BE%AE%E6%9C%8D%E5%8A%A1/3.7%20%E4%BD%BF%E7%94%A8Maven%E6%8F%92%E4%BB%B6%E6%9E%84%E5%BB%BADocker%E9%95%9C%E5%83%8F.md?dir=0&filepath=3+%E4%BD%BF%E7%94%A8Docker%E6%9E%84%E5%BB%BA%E5%BE%AE%E6%9C%8D%E5%8A%A1%2F3.7+%E4%BD%BF%E7%94%A8Maven%E6%8F%92%E4%BB%B6%E6%9E%84%E5%BB%BADocker%E9%95%9C%E5%83%8F.md&oid=9b51d3c464471f9b968f43c626b7446c8319ef71&sha=d1c33ad8158f8a25db7eb3af18fef2d91c7be668)
  * 。。。。

## markdown
1. 相关资料
  * [中文markdown站点](http://www.markdown.cn/)
  * [markdown学习笔记](http://www.jianshu.com/p/4Q3aay)
  * [编辑器介绍](http://www.williamlong.info/archives/4319.html) 选用Atom
  * [**Markdown——入门指南**](http://www.jianshu.com/p/1e402922ee32/)
  * [markdown编辑器语法——字体、字号与颜色](http://blog.csdn.net/testcs_dn/article/details/45719357/)
  * [markdown语法详解](http://www.kuqin.com/shuoit/20141125/343459.html)
  * 。。。。

## spring boot admin
1. 相关资料
  * [spring-boot-admin](https://github.com/codecentric/spring-boot-admin)
  * [Reference Guide](http://codecentric.github.io/spring-boot-admin/1.4.2/)
  * [Spring Boot Admin的使用](http://www.jianshu.com/p/e20a5f42a395)
  * 。。。。

## spring cloud config
1. 相关资料
  * [Spring Cloud构建微服务架构（四）分布式配置中心](http://blog.didispace.com/springcloud4/)
  * [Spring Cloud构建微服务架构（四）分布式配置中心（续）](http://blog.didispace.com/springcloud4-2/)
  * 。。。。
2. 问题点
  * 高可用，集群（**conifg-server引入eureka注册服务，config-client则需开启通过服务发现的方式访问conifg-server**）
  * 配置文件修改后，应用集群的自动化更新

## spring boot
* 国际化消息配置，与hibernate validation配合使用，保存时可对常见的验证规则定制相应的友好提示。
 * [Spring Boot国际化（i18n）](http://blog.csdn.net/linxingliang/article/details/52350238)
* 。。。。

## etcd
* [etcd：从应用场景到实现原理的全方位解读](http://www.infoq.com/cn/articles/etcd-interpretation-application-scenario-implement-principle/)

## kubernetes
相关资料
[Kubernetes初探：原理及实践应用](http://www.csdn.net/article/2014-10-31/2822393)
[一个适合 Kubernetes 的最佳网络互联方案](http://wwwbuild.net/dockerone/127784.html)

* 更改kubernetes配置后，启动应用程序
```
cd /root/app_deploy
sh app_deploy_st.sh -h
sh app_deploy_st.sh -p app_name -v 3.0.1.P1
```
* 测试环境的运行情况
```
kubectl get pod --namespace=st-eyd -o wide
kubectl get pod --namespace=kube-system -o wide
```

## swagger
All Swagger Resources(groups) http://localhost:8080/springfox/swagger-resources  
Swagger UI endpoint: http://localhost:8080/springfox/swagger-ui.html  
Swagger docs endpoint: http://localhost:8080/springfox/v2/api-docs  

## zipkin
* [#研发解决方案介绍#Tracing(鹰眼)](http://www.cnblogs.com/zhengyun_ustc/p/55solution2.html)
* [Twitter zipkin 分布式跟踪系统的设计与实现](http://blog.csdn.net/alex19881006/article/details/24404209)

## 技术选型
* [creating microservices](http://pretius.com/devoxx-2015-poland-creating-microservices/)

## gradle
* 常用命令
```
gradle build -x test --stacktrace
grdle publish
```
* [Gradle系列教程之依赖管理](http://www.open-open.com/lib/view/open1431391503529.html)
* [使用Gradle部署jar包到Maven中央库](http://ningandjiao.iteye.com/blog/1846441)
* [maven/gradle 打包后自动上传到nexus仓库](http://www.cnblogs.com/yjmyzz/p/auto-upload-artifact-to-nexus.html)


## hibernate
* Hibernate session FlushMode有五种属性：
```
1、NEVEL：已经废弃了，被MANUAL取代了
2 MANUAL：
如果FlushMode是MANUAL或NEVEL,在操作过程中hibernate会将事务设置为readonly，所以在Spring与Hibernate集成后进行增加、删除或修改操作过程中会出现如下错误
org.springframework.dao.InvalidDataAccessApiUsageException: Write operations are not allowed in read-only mode (FlushMode.NEVER) - turn your Session into FlushMode.AUTO or remove 'readOnly' marker from transaction definition；
解决办法：配置事务，spring会读取事务中的各种配置来覆盖hibernate的session中的FlushMode；
3 AUTO
设置成auto之后，当程序进行查询、提交事务或者调用session.flush()的时候，都会使缓存和数据库进行同步，也就是刷新数据库。
4 COMMIT
提交事务或者session.flush()时，刷新数据库；查询不刷新
5 ALWAYS：
每次进行查询、提交事务、session.flush()的时候都会刷数据库
ALWAYS和AUTO的区别：当hibernate缓存中的对象被改动之后，会被标记为脏数据（即与数据库不同步了）。当 session设置为FlushMode.AUTO时，hibernate在进行查询的时候会判断缓存中的数据是否为脏数据，是则刷数据库，不是则不刷， 而always是直接刷新，不进行任何判断。很显然auto比always要高效得多。

JPA的FlushModeType只有两种：
1、COMMIT：仅当提交事务时才能进行刷新
2、AUTO：（默认）在执行查询时进行刷新
```

* 对于程序中写的update语句，并没有及时输出到控制台，这和Hibernate session的flushMode有关，参考上面
```
AUTO-只有在发生下次查询且只针对当前实体类的查询的时候才会flush到db,这时候控制台才会打印出sql
COMMIT-只有在事务提交的时候才提交sql语句到db
```
