# Something About Mysql
## install for MacOS
* 下载mac版安装包，并进行安装
* 安装后mysql命令无法识别，需要alias一下
```
alias mysql=/usr/local/mysql/bin/mysql
alias mysqladmin=/usr/local/mysql/bin/mysqladmin
```
* [参考](https://dev.mysql.com/doc/refman/8.0/en/osx-installation-notes.html)
* `8.0`版本的密码认证增强版，需在初始化数据库的时候更改为`Legacy Password Encryption`，否则会导致`navicat`工具连接不上
```
系统偏好设置->mysql->initialize database
```

## 初始化库与用户
```
# 建库
CREATE DATABASE db_jgs DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
# 建用户
CREATE USER 'user_jgs'@'%' IDENTIFIED BY 'lt123';
# 赋权
GRANT ALL ON db_jgs.* TO 'user_jgs'@'%';
```
