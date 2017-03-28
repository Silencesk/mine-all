# 博客搭建
这里将记录个人博客搭建的历程，如果你也想搭建一个属于个人私有空间的博客系统，那可以继续阅读下去。希望这篇文章的记录，能对你有所帮助。

## 博客选型
关于选型参考类的文章：[hexo入门指南](http://www.maintao.com/2014/hexo-beginner%27s-guide/)；这篇文章主题是hexo相关的，但作者在文章中也讲述了关于选型方面的内容，可供参考。对于我个人来说，能支持Markdown，一套自我感觉良好的主题（自由发挥了）就ok了。

### Hexo
Hexo是一个快速，简单并且强大的博客框架。你可以用`Markdown`编写文章，Hexo则可以在几秒以内生成拥有漂亮主题的静态文件。
* 本来是想写写教程的，发现人家官方便有很详尽的文档，也建议大家多看看官方资料。虽然这样时间花的可能多些，但试着去理解原生的东西总会让我们收获更大，若实在觉得难以理解，便可以搜索其他资料，加以参考。[Hexo](https://hexo.io)
* 主题`indigo`
  * [网站参考](https://imys.net/)
  * [源码参考](https://github.com/yscoder/hexo-theme-indigo)
  * [搭建教程](http://www.jianshu.com/p/465830080ea9)
* 主题`yilia`
  * 网站参考：[litten](http://litten.me/) or [joway](https://joway.github.io/)
* 主题`notes`
  * [网站参考](http://notes.iissnan.com/)
  * [源码参考](https://github.com/iissnan/hexo-theme-notes)
  *
* 需按照步骤，重新安装Hexo
* 规划功能列表
  * 搜索
  * 相册
  * [打赏](http://www.midaoi.com/2016/10/27/hexoError/)

#### 教程
* 初级教程：(Create and host your blog for free with hexo & Github)[https://malekbenz.com/blog/2016/09/10/Create-Host-Blog-for-free-with-Hexo-Github]
* 参考现成的解决方案，总要比自己折腾，成果来的快些。参考下这位仁兄的[Hexo折腾记](https://yq.aliyun.com/articles/8607?do=login)

#### troubleshooting
1. 使用hexo命令会报如下错误
```javascript
Error: Cannot find module './build/Release/DTraceProviderBindings'
  at Function.Module._resolveFilename (module.js:469:15)
  at Function.Module._load (module.js:417:25)
  at Module.require (module.js:497:17)
  at require (internal/module.js:20:19)
  at Object.<anonymous> (/usr/local/lib/node_modules/hexo-cli/node_modules/dtrace-provider/dtrace-provider.js:17:23)
```
`找到dtrace-provider.js，并将console.log的地方注释掉就ok了。`[参考](http://www.midaoi.com/2016/10/27/hexoError/)

2. node scripts/install.js 卡住不动  
`npm默认会从国外的服务器下载，可指定国内的淘宝npm镜像源`
[参考1](http://blog.csdn.net/zhy421202048/article/details/53490247)  or [参考2](http://npm.taobao.org/)

3. 按照正常的步骤执行了，但在hexo server后，进行访问时 `Error Cannot GET /`  
`hexo安装缺失一些内容`，[参考](http://www.jianshu.com/p/465830080ea9)

4. 使用`hexo deploy`报错
```javascript
TypeError: source.replace is not a function
    at Object.exports.parse (/Users/mokeo/blog/node_modules/.1.4.2@swig/lib/parser.js:438:19)
    at parse (/Users/mokeo/blog/node_modules/.1.4.2@swig/lib/swig.js:354:19)
    at Object.precompile (/Users/mokeo/blog/node_modules/.1.4.2@swig/lib/swig.js:486:23)
    at Object.compile (/Users/mokeo/blog/node_modules/.1.4.2@swig/lib/swig.js:606:16)
    at commitMessage .....
```
关键信息`commitMessage`。因博客根目录下的，`_config.yml`配置文件中deploy.message提交信息错误。需要加上引号，[参考](https://github.com/hexojs/hexo/issues/1810)
```yaml
deploy:
  type: git
  repo: https://github.com/Silencesk/Silencesk.github.io.git
  branch: master
  message: "{{ now('YYYY-MM-DD HH:mm:ss') }}"
```

### jekyll
// TODO: 待补充。。。
