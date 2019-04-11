# novel-middleware springclouddemo
DONE AND TODO:
novel-middleware 一个atomikos+activemq+redis架构 分布式事务管理器框架+支持事务的消息队列框架 => 保证缓存最终一致性的推送系统
优点：
直接使用JMS框架的分布式事务特性支持，不必再使用消息记录表和消息记录消费失败时的消息记录扫描重新消费机制——代码简洁
且消息记录在硬盘上持久化时生成线性日志比通过在业务操作后人工编写将操作记录日志持久化到规范化（非线性）结构的消息记录表的代码的方式运行性能更高
且将消息记录的持久化从核心业务数据库运行机器上剥离到mq运行机器上减少数据库机器性能负担


-------------------
springclouddemo是springcloud项目 切换application.properties中spring.profiles.active属性激活不同节点以开发 注册中心、生成者、消费者、断路器、路由网关、分布式配置中心

---------------------
面对多变动产品经理需求的开发流程（排列有序，不可颠倒）
1、业务逻辑正确
2、程序稳定健壮
3、数据传输存储安全
4、性能尽量提升
先写对业务，再处理异常，再保证数据安全，最后再尽量提升性能，前三个是必要项，最后一个是充要项。


----------------
https://download.springsource.com/release/STS/3.9.6.RELEASE/dist/e4.9/spring-tool-suite-3.9.6.RELEASE-e4.9.0-win32-x86_64.zip