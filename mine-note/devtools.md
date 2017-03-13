# 开发工具
用于记录常用开发工具的操作。
* [eclipse](#eclipse)
* [atom](#atom)
* [IntelliJ IEDA](#intellij-idea)

## eclipse·
eclipse-neon，基于eclipse neon 4.6.1版本，并增加了符合我们工作环境的一些相关插件，具体列表如下
* `biz.junginger.ExploreFS_1.0.0.jar` 右键文件定位
* `lombok.jar` javabean 简化，参考[lombok](https://projectlombok.org/)
* `jboss-tools` freemarker语法高亮支持
* 自带的json格式化，语法高亮

## atom
Atom是专门为程序员推出的一个跨平台文本编辑器。具有简洁和直观的图形用户界面，并有很多有趣的特点：支持CSS，HTML，JavaScript等网页编程语言。它支持宏，自动完成分屏功能，集成了文件管理器。  

* [简介](http://www.open-open.com/lib/view/open1457082318187.html)
* 安装插件慢，被墙，使用国内镜像。[参考](http://blog.csdn.net/dqliangjun/article/details/52075641)
```
-- 永久设置
npm config set registry https://registry.npm.taobao.org
-- 临时设置
npm --registry "http://npm.hacknodejs.com/" install underscore
```

* [atom常用插件集合](https://github.com/kompasim/atom-plugins)
* [快捷键](http://blog.csdn.net/crper/article/details/45674649)
  * markdown效果预览`ctr+shift+m`，可以在预览页面导出为html
  * 打开设置页`ctr+,`
  * 在打开的文件中快速定位文件`ctr+t`
  * 在当前编辑文件中定位方法`ctr+r`  
  * `shift+cmd+P`进入命令行模式


  英文 | 中文 | 快捷键
  ---|---
  Toggle Full Screen | F11 | 全屏
  Increase Font Size | Ctrl + Shift + "+" | 增大字体 ctr+鼠标轮动
  Select Line	| 选定一行 | Ctrl + L
  Delete Line	| 删除一行 | Ctrl + Shift + K
  Indent | 增加缩进 | Ctrl + [
  newline-below|光标

  Go to Line|	跳转到某行	|Ctrl + G
  Toggle Commadn palette|全局搜索面板|Ctrl + Shift + P
* [专栏：Atom编辑器](http://blog.csdn.net/crper/article/details/45674649)
* [Github开源编辑器Atom常用插件及安装方法](http://blog.csdn.net/mduanfire/article/details/50278591)
* [atom 本地插件安装](http://jingyan.baidu.com/article/375c8e19c3105a25f2a22901.html)

## intellij idea
* 常用快捷键  [快捷键](#IntelliJ-IDEA-keys)
>**双击shift 在项目的所有目录查找，就是你想看到你不想看到的和你没想过你能看到的都给你找出来**  
 ctrl+shift+f 当前项目查找包含特定内容的文件  
 **ctrl+n 查找类**  
 ctrl+e 最近的文件  
 **alt+F7 非常非常频繁使用的一个快捷键，可以帮你找到你的函数或者变量或者类的所有引用到的地方**    
 ctrl+f4 关闭当前窗口  
 =========  
 **shift+F6 非常非常省心省力的一个快捷键，可以重命名你的类、方法、变量等等，而且这个重命名甚至可以选择替换掉注释中的内容**  
 ctrl+d 复制当前行到下一行  
 ctrl+z 撤销  
 ctrl+shift+z 取消撤销  
 ctrl+k 提交代码到SVN  
 ctrl+t 更新代码  
 **ctrl+y 删除当前行**  
 **f2/shift+f2 定义下一个错误**  
 **ctrl+alt+o 优化导入的类和包**  


* 代码注释，[参考](https://my.oschina.net/baishi/blog/612641)
```java
/**
 * ${DESCRIPTION}
 * @author liutao
 * @create ${YEAR}-${MONTH}-${DAY} ${TIME}
 */
```


* [安装lombok](http://blog.csdn.net/hinstenyhisoka/article/details/50468271)
* [IDEA 环境常用设置整理](http://blog.csdn.net/lk_blog/article/details/43115903)
* [IntelliJ IDEA 设置 编辑器字体大小背景色及快捷键](http://blog.csdn.net/lifuxiangcaohui/article/details/38822649)
* [**IntelliJ IDEA 使用心得与常用快捷键**](http://www.blogjava.net/rockblue1988/archive/2014/10/25/418994.html)
* [**十大Intellij IDEA快捷键**](http://blog.csdn.net/dc_726/article/details/42784275)
