# 工作常用
* [linux](#linux)
* [maven](#maven)
* [vim](#vim)
* [windows](#windows)
* [redis](#redis)
* [mysql](#mysql)
* [java](#java)
* [git](#git)
* [eclipse](#eclipse)

## linux
+ chmod +x restart_tomcat8080.sh
+ 1,$s/apache-tomcat-7.0.53-82/apache-tomcat-es-1010/g
+ 文件从远程主机copy到当前系统 `scp -r local_folder remote_username@remote_ip:remote_folder`
+ kill -9 \`ps uxa|grep 10071|awk '{if($11 != "grep") {print $2}}'\`
+ netstat -ntlp

## maven
* 常用
```
mvn clean install -Dmaven.test.skip=true
mvn clean source:jar deploy -Dmaven.test.skip=true -Pprod -U
mvn clean source:jar deploy -DskipTests
mvn clean install -Dmaven.test.skip=true -DdeployEnv=dev -U
mvn dependency:tree
```

* 上传第三方jar至私服
```
--本地setting.xml增加段
<server>
  <id>thirdparty</id>
  <username>deployment</username>
  <password><![CDATA[deployment@belle]]></password>
</server>
--使用命令
mvn -f ./eyd-uc-core clean
mvn deploy:deploy-file -DgroupId=com.octo.captcha -DartifactId=jcaptcha -Dversion=2.0-alpha-1 -Dpackaging=jar -Dfile=jcaptcha-2.0-alpha-1.jar -Durl=http://${repository_url}/nexus/content/repositories/thirdparty/ -DrepositoryId=thirdparty
```

* 国内公有maven私服
```
http://maven.aliyun.com/nexus/content/groups/public/
http://maven.oschina.net/content/groups/public
```

## vim
* gg #跳到文件的开始
* G #跳到文件的结束
*

## windows
* echo %cd%		显示当前目录路径
* dir				列出当前目录文件列表
* E:\workProgram
* E:\workProgram\Java\jdk1.7.0_71
* C:\ProgramData\Oracle\Java\javapath
* C:\Users\gekeo\AppData\Roaming\Microsoft\Windows\Start Menu\Programs

## redis
* LPUSH mylist "three"
* RPOP mylist
* LRANGe uc_user_push_datas_1 0 -1
* `flushdb` #清除db的所有缓存


## mysql
```
alter table t_book rename to bbb;
alter table bbb change nnnnn hh int;
mysqldump -u root -p db_uc > db_uc.sql

```

## java
* outofmemory -XX:MaxPermSize=256m
* outofmemory -Xmx128m -Xmx512m
* -javaagent:E:\app_settings\eclipse\reload\springloaded-1.2.5.RELEASE.jar -noverify

## git
* `git branch -a` 查看仓库所有分支
* `git checkout -b feature origin/feature-20160914` 拉取远程分支并重命名为feature
* **fork的项目同步源的更新，通过git命令处理。**[**参考**](https://segmentfault.com/q/1010000002590371)
```
1.首先要先确定一下是否建立了主repo的远程源：  
  git remote -v
2.如果里面只能看到你自己的两个源(fetch 和 push)，那就需要添加主repo的源：  
  git remote add upstream URL
  git remote -v
然后你就能看到upstream了。  
3.如果想与主repo合并：  
  git fetch upstream
  git merge upstream/master
**4.该命令必须要在git自带的命令行窗口运行，而不能在cmd下面，否则会报权限错误**  
```
* fork的项目同步源的更新，还可以通过souceTree工具处理，对于本地仓库，可以指定多个远程仓库，在pull的时候指定一下远程仓库

* `git checkout .` 撤销所有未提交的修改
* `git merge --abort` 合并时遇到冲突想取消操作,恢复index
* `git reset --hard`可以回退到某个提交
* `git revert` 可以撤销某个提交，撤销会产生一个新的提交
* 。。。。

## eclipse
使用备注

```java
 /**
 * Description:
 * author:      liutao
 * Createdate:  ${date}${time}
 *
 */
 or
/**
 * @ClassName: ${type_name}<br>
 * @Description: <br>
 * @author liutao<br>
 * @date ${date}${time}<br>
 *
 */
 ```

 ## accont
 ```

 ```
