# Spring Cloud Stream RabbitMQ Demo 
这是一个简单的应用示例，采用了Spring Cloud Stream来消费RabbitMQ exchange topic messages, 并且把读取到的消息保存到数据库(MariaDB here) 

# 必要前置条件
你必须确保已经安装 JDK8, Maven3.*, 并且已经配置好一个名为mq_demo的数据库

# 执行步骤
### 编译
执行 `mvn clean package`

### 运行 
可以在IDE里直接运行DemoApplication, 或者执行 `mvn spring-boot:run`, 再或者运行 `./target/demo-0.0.1-SNAPSHOT.jar`)

### 在RabbitMQ管理后台添加一个Exchange
登录后点击*Exchanges* tab, 然后点击在exchanges列表下方的 *Add a new exchange*, 打开后输入inputDemoTopic作为Exchange Name并且把Type改为topic最后点击*Add exchange*按钮保存.

### 发布消息
点击Exchanges列表中你刚创建好的Exchange Name (在这里是inputDemoTopic), 然后打开*Publish message* tab并输入`{"name": "your name", "email": "your email"}`最后点击*Publish message*按钮发布消息.

### 当当当当
你可以在此应用运行的console看到打印出的以*Received Emp message: blabla*为开始的日志, 并且数据已经保存到了你配置的数据库对应的数据表里(这里是mq_employee表)