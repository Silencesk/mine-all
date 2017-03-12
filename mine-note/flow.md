# 开发 and 转测流程
## git flow


## gitlab flow
关键点
* 所有的开发任务都是从issue开始，便于代码追踪
* 所有的开发其实是基于源仓的master分支，开发者通过fork后的merge requests合并到源仓的master分支。只有被项目的master接受的merge request才是有效提交。
* 开发者的职责比较明确，项目master职责会多很多。  
这种方式对于master角色的要求更高，开发者可以不用关心当前项目的版本，对于开发者，与源仓库相关的就只有master分支，只需要完成自身的issue即可；  
而项目的master不仅要审查好开发者提交的代码，还需要根据源码中的特定提交去发布版本，并做好版本发布。
*

参考资料：  
* [gitlab社区版功能演示](https://gitlab.com/gitlab-org/gitlab-ce)
* [GitLab Flow](http://www.15yan.com/topic/yi-dong-kai-fa-na-dian-shi/6yueHxcgD9Z/)  
* [GitLab的Pull Request工作流](http://www.jianshu.com/p/6bcd082101c1)

# CI and CD
## gitlab pipeline

## jekins ci & cd
jekins的持续发布机制  
https://github.com/jenkinsci

http://www.linkedin.com/pulse/devops-continuous-delivery-pipeline-docker-jenkins-gitlab-kapil-arora

# 工程版本管理
## maven-release-plugin
* [apache maven-release-plugin 版本管理方式](http://blog.csdn.net/helloworldwt/article/details/48241801)  
* [Jenkins and Maven Release plugin](http://www.codeyouneed.com/jenkins-maven-release-plugin/)
* [M2 Release Plugin](https://wiki.jenkins-ci.org/display/JENKINS/M2+Release+Plugin)

## versions-maven-plugin
用于项目pom文件版本更新，只能更新它本身版本和它子模块的版本。  
并不适用于我们当前的项目结构。

## 版本管理
使用git-flow管理代码，版本的升级通过【版本升级脚本+sourceTree】实现。
* 发版
