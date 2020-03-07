# python
## 安装环境
* `virtualenv`
```
# install
pip3 install virtualenv

# use 进入到项目目录
virtualenv --no-site-packages venv
```
* 设置国内pip源
```
mkdir ~/.pip
vi ~/.pip/pip.conf
-------------------
[global]
index-url = https://mirrors.aliyun.com/pypi/simple/

[install]
trusted-host=mirrors.aliyun.com
-------------------
```
*
