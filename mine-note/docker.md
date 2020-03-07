# docker
## 常用命令
```
-- 获取上线的容器id
docker ps -a | grep eyd-uc-web | grep -v pause| awk '{print $1}'

-- 获取上线容器的pid
docker inspect --format "{{ .State.Pid }}" `docker ps -a | grep keywords | grep -v pause| awk '{print $1}'`
```

## 相关资料
* [菜鸟教程](https://www.runoob.com/docker/docker-architecture.html)
