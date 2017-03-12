## 基本概念收集
## java7
* try-with-resources
```java
try (Stream<User> stream = repository.findAllByCustomQueryAndStream()) {
  stream.forEach(…);
}
```

## 并发锁
并发乐观锁重试机制，可解决一概使用数据库悲观锁而导致并发性能不佳的问题  
* [并发锁事务重试机制](http://www.myexception.cn/open-source/2048186.html)
* 乐观锁为什么需要重试机制，是因为并发情况下，按照正常逻辑只会有一个用户的操作可以成功，其他的操作都会失败；避免返回给其他用户失败的信息，而需要用户重新提交操作，则增加自动重试机制；在其他操作发生异常后，重新去获取数据，并提交更新操作。
* [并发锁事务重试机制（JPA高并发下的乐观锁异常）](http://nanjiwubing123.iteye.com/blog/2261394)

## top
* linux下的top，`p`-按cpu使用率排序； `m`-按内存使用率排序
* mac下的top，先输入`o`，然后输入：`cpu`-按cpu使用率排序；`rsize`-按内存使用率排序
* 如果记不清了，可输入`?`，弹出帮助界面
