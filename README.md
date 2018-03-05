部署方法：
- 通过git下载源码；
- 创建数据库springboot_dubbo，数据库编码为UTF-8；
- 导入doc/springboot_dubbo.sql文件，默认文件中已包含初始化数据；
- 修改application.yml文件，更新MySQL账号和密码；
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

