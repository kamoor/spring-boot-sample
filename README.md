#Description: Trying to use spring boot module and bring tomcat up and running. 


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
Added Caching for testing purpose. (See cache package to learn)



Include static resources
========================

1. create folder src/main/resources/public. Maven will move public folder to classpath while build.
2. Add any non-jsp resources in public or sub folders.
3. Note: You can create any folder like this and map as resource location in spring
4. Note: JSP will not get executed from this folder


Include JSP in jar File:
========================
1. JSP is a whole different story. Include tomcat-embed-jasper in pom dependency 
2. Now all the JSP in above (resources/public) folder will give you an error or white page.
3. To fix this, create folder src/main/resources/META-INF/resources/ then move all jsp in (or sub folders) it. Here I created src/main/resources/META-INF/resources/jsp/helloworld.jsp
4. Now maven will move these files to /META-INF/.... This is what Servlet 3.0 expect.
5. Run server and access localhost:8080/jsp/helloworld.jsp

Nows lets try to configure using spring MVC
6. See JSPController.java, it uses above given helloworld.jsp
7. You can browse http://localhost:8080/helloworld to see jsp in action
8. Note: You can also store any resources under META_-INF , for example css, js etc.


A simple performace comparison between Spring Rest vs RMI using spring boot
===========================================================================
 See packages  com.samples.rmi.* for RMI implementation
 See com.samples.boot.controllers.UserForPerfTestController for endpoint. 

 Test Result from Macbook Pro 2.7 GHz, 16GB 1600 MHz DDR RAM, OSX Yosemite, JDK 1.8 is given below

 REST WINS!!!


RMI based service
----------------------------
4 rounds using 5  request, 1000 Request in total :  ab -n1000 -c5 http://localhost:9090/perf/remoting


Time per request:       47.482 [ms] (mean)
Time per request:       9.496 [ms] (mean, across all concurrent requests)


Time per request:       39.989 [ms] (mean)
Time per request:       7.998 [ms] (mean, across all concurrent requests)


Time per request:       41.329 [ms] (mean)
Time per request:       8.266 [ms] (mean, across all concurrent requests)


Time per request:       40.811 [ms] (mean)
Time per request:       8.162 [ms] (mean, across all concurrent requests)



REST based service 
-----------------------------
4 rounds using 5  request, 1000 Request in total : ab -n1000 -c5 http://localhost:9090/perf/rest


Time per request:       32.753 [ms] (mean)
Time per request:       6.551 [ms] (mean, across all concurrent requests)

Time per request:       29.905 [ms] (mean)
Time per request:       5.981 [ms] (mean, across all concurrent requests)


Time per request:       28.916 [ms] (mean)
Time per request:       5.783 [ms] (mean, across all concurrent requests)

Time per request:       27.966 [ms] (mean)
Time per request:       5.593 [ms] (mean, across all concurrent requests)



