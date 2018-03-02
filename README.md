部署方法：
- 开启虚拟机zookeeper
- 开启虚拟机dubbo
- 检查dubbo_provider.xml、dubbo_consumer.xml中的zookeeper地址是否正确
- maven编译
- 开启DubboProviderApplication.java
- 开启DubboConsumerApplication.java
- 访问http://127.0.0.1:8081/sendMsg，查看结果：显示“CC发送了一条消息......”则成功。
