# MY-FIRST-STEP-IN-JEE
---
#### This project is a curd app .. it's a result of my first step in java web ( JEE )  ... 

## What technologies that i used ?
 - Apache Tomcat 
 - Servlet 
 - JDBC
 - mySQL
 - JSP
 - Bootstrap (CDN) 4.3.1



## Setup prerequists
 - You have to install [JAVA JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) ,  your preferred [IDE](https://www.google.com/search?q=java+ide) ( i use [eclipse](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers) because it's light on the computer ) , [Apache Tomcat](http://tomcat.apache.org/) , [jdbc connector](https://dev.mysql.com/downloads/connector/j/) according to your mysql server version ..   

## How to run the application
 - Clone or download files in some place.
 - Open the project in your IDE.
 - Execute this code in your mysql server : 
 ```sql
 CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
);
 ```
 - Then make sure to change the username and the password of the db server in the ``` ClientDB ``` class and the folder name in ``` index.jsp ``` file ..

 - Run the app. 

## Note : 
#### I use the eclipse IDE ..

## Demo 
![quick-demo](demo/demo.gif)
  
#### License
---
[MIT](https://choosealicense.com/licenses/mit/)  
