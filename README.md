#Description: Trying to use spring boot module and bring tomcat up and running. 
#author: kamoor


How to Run in Just 3 steps:
==========================

1.	Pull Maven project from github.
2.	Got to Project root & run following command. It will package and start the application in tomcat server.
    mvn clean package && java -jar target/*.jar
3.	Now you can browse to http://localhost:8080/users/1. You can add context path by editing application.properties file

How to configure tomcat server:
===============================
All the configuration are bundles in src/main/resources/application.properties
Port, catalina_base etc etc are configured in this folder.


Few Options with Spring boot:
=============================c
All most all the parameters can be configured using application.properties or passing parameter through command line arguments.
Example:
mvn clean package && java -jar target/*.jar –debug
mvn clean package && java -jar target/*.jar –server.port=9090

Some Help On Spring Boot Configuration:
======================================
Learn basics from http://projects.spring.io/spring-boot/
Look at the Server.java to understand how server is configured to load spring context.
Added HSQLDB auto configuration also now.


Issue Found: 
============
1.
@EnableAutoConfiguration and @ComponentScan did not really pick all the controllers in all the packages.
thats the reason I added ImportResource again and defined ComponentScan packages in xml file. 

2. Must keep all resource files under src.main.resources folder. Otherwise maven will not package in to jar file


