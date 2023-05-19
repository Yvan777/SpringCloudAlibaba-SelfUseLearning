# SpringCloudAlibaba-SelfUseLearning
学习cloud二代的过程
使用版本如下：
spring-boot 2.6.13
spring-cloud 2021.0.5
spring-cloud-alibaba 2021.0.5.0
mysql 8.0.15
学习之路 
1.eureka 集群
2.nacos 2.2.0 的学习 
    - nacos 单机及集群的搭建
    - nacos 服务注册与发布
    - nacos config的动态配置及共享
    - 顺便了解了一下springboot配置文件启动的源码
3.sentinel 1.8.6 的学习
    - sentinel流控及熔断
    - sentinel 结合nacos 将配置落地(同步nacos的配置,不过如果要双向同步,需要改sentinel源码,网上有教程)
    - @SentinelResource注解 自定义处理流控熔断信息
    - 自定义父类MyBlockExceptionHandler.class去处理流控熔断信息,跟2.7类似,不同的是2.7精确到具体的类方法,2.8是如果不设置2.7就走2.8
4.gateway 学习
    - 自动路由配置
    - 手动路由配置
    - 手动路由多种断言规则学习
    - 手动路由过滤器学习
    

进行中......
