# **e-Commerce-online Spring Boot**

<img src="https://commons.bmstu.wiki/images/5/59/Sring-boot-logo.png" alt="drawing" width="300" height="160" />

## Descripton

This is e-Commerce project for a made up cosmetic shop. This app has all the basic functionality every e-Commerce shop needs. You can create a new product and put up a category for it. It is going to be registered in the PostgreSQL database. 

A customer can choose a multiple products, which is going to be sent at the shopping cart, where customer needs to type in his personal data and payment method. Then he can make an order. Order eventually going to be registered in the database, where we now can get which orders particular customer has made.

## Technical Stack:

Java 8/11, Spring (Boot, MVC, Data, Security), ORM (JPA, Hibernate), SQL (PostgreSQL)

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
