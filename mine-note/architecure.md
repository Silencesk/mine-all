# 架构设计
## 架构理念
* 简单易用，避免做太多无必要的设计
*

## 关于架构设计的几点思考
* 在微服务的框架中，当程序运行单元较小的情况下，程序是否有必要分层？如果分层，最佳的分层结构是怎样的？
```java
// 非必要观点
1. 当微服务的粒度适当小的情况，若再去分层，导致整体项目代码结构过于庞大
2. 工程结构
  itdd-link
    itdd-link-common                // common:包含给第三方调用的的api,dto；独立版本与工程版本不一致
      |-common
        |-dto
        |-util
        |-constants
        |-api
    itdd-link-app                 // app:包含dao,service,web层；提供rest接口
      |-dao
        |-mapper
        |-domain
          |-vo
      |-service
      |-web
// 分层（项目代号-工程-分层）
1. 传统分层结构
  itdd-link
    itdd-link-common
    itdd-link-dao
    itdd-link-service
    itdd-link-manager
    itdd-link-web
2. 简化版分层（参考阿里）
  itdd-link
    itdd-link-dao
    itdd-link-service
    itdd-link-web
3. 再简化版分层
  itdd-link
    itdd-link-common
    itdd-link-core
      |-dao
        |-mapper
        |-domain
          |-vo
      |-service
    itdd-link-web
    itdd-link-api
```
* 在接口编程盛行的背景下，应用程序多采用一个接口，一个实现类的方式。现在的问题是：这种接口是否有必要？
```java
// 非必要的观点
1. 造成接口泛滥，应用程序中大概有80%的情况都不需要接口。对于应用本身的调用完全无必要抽象接口，而给其他应用调用的情况，才考虑提供接口出来；
2. 当需要为服务增加一个方法时，需要调整接口类+实现类
3. 能有效控制接口方法，最大限度减少范围，最好不要提供一个大而全的接口；

```
