# Spring Cloud Stream RabbitMQ Demo 
This is a very basic application that used Spring Cloud Stream to consume RabbitMQ exchange topic messages, and then save it into database (MariaDB here) 

# Pre-requisite
You have to make sure you've installed JDK8, Maven3.*, and already had a mq_demo database configured

# Run steps
### To Build
run `mvn clean package`

### To Run 
run it in IDE, via maven `mvn spring-boot:run`, or run `./target/demo-0.0.1-SNAPSHOT.jar`)

### To Add a new exchange in RabbitMQ Management Console
Go to *Exchanges* tab once you logged in and then expand the *Add a new exchange* href under the table of exchanges and enter inputDemoTopic as the Exchange Name and change the Type to topic, at last click *Add exchange* button to save it.

### To Publish a message
Click the Exchange Name you just created (e.g. inputDemoTopic) in the Exchanges table, expand the *Publish message* tab and input `{"name": "your name", "email": "your email"}` then click *Publish message* button.

### You Won it
Yeah, you are able to see a printed out log started with *Received Emp message: blabla*, and then check your database