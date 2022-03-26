# **e-Commerce-online Spring Boot**
<p alight="center">
<img src="https://commons.bmstu.wiki/images/5/59/Spring-boot-logo.png" alt="drawing" width="300" height="160" /> 
</p>

## Descripton

This is e-Commerce project for a made up cosmetic shop. This app has all the basic functionality every e-Commerce shop needs. You can create a new product and put up a category for it. It is going to be registered in the PostgreSQL database. 

<img src="https://www.pngplay.com/wp-content/uploads/6/E-Commerce-Logo-Background-PNG-Image.png" alt="drawing" width="200" height="200" />

A customer can choose a multiple products, which is going to be sent at the shopping cart, where customer needs to type in his personal data and payment method. Then he can make an order. Order eventually going to be registered in the database, where we now can get which orders particular customer has made.

## Technical Stack:

Java 8/11, Spring (Boot, MVC, Data, Security), ORM (JPA, Hibernate), SQL (PostgreSQL)

<img src="https://cdn-icons-png.flaticon.com/128/226/226777.png" alt="drawing" width="40" height="40" />    <img src="https://cdn-icons-png.flaticon.com/512/5968/5968342.png" alt="drawing" width="40" height="40" />    <img src="https://cdn-icons-png.flaticon.com/512/188/188333.png" alt="drawing" width="40" height="40" />   <img src="https://cdn-icons.flaticon.com/png/512/3211/premium/3211296.png?token=exp=1648311619~hmac=d9fa74c7c5edd87e2a0403e25be22579" alt="drawing" width="40" height="40" />   <img src="https://seeklogo.com/images/H/hibernate-logo-8C95C75A24-seeklogo.com.png" alt="drawing" width="40" height="40" />

## Installation
You can clone this repository and use it localy:

    $ git clone https://github.com/Nursultan25/eCommerce_online.git

#### Using Maven plugin

First you should do clean installation:

    $ mvn clean install
You can start application using Spring Boot custom command:

    $ mvn spring-boot:run
#### Using Maven plugin and running JAR

You can create JAR file using:

    $ mvn clean package
and then run it with:

    $ java -jar target/shop-x.x.x.jar
