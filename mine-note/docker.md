# docker
```
-- 获取上线的容器id
docker ps -a | grep eyd-uc-web | grep -v pause| awk '{print $1}'

-- 获取上线容器的pid
docker inspect --format "{{ .State.Pid }}" `docker ps -a | grep keywords | grep -v pause| awk '{print $1}'`
```