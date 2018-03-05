部署方法：
- 开启虚拟机zookeeper；
- 开启虚拟机dubbo；
- 检查dubbo_provider.xml、dubbo_consumer.xml中zookeeper配置信息是否正确；
- maven编译；
- 开启DubboProviderApplication.java；
- 开启DubboConsumerApplication.java；
- 访问：
<br>
http://127.0.0.1:8081/sendMsg，若返回“CC发送了一条消息......”则成功；
<br>
http://127.0.0.1:8081/user/1，若返回对象信息则成功；
<br>
http://127.0.0.1:8081/user/list，若返回对象集合信息则成功。

