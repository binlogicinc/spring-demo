# spring-demo

Create schema:
```
CREATE DATABASE spring;
USE spring;
CREATE TABLE `EMPLOYEE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRSTNAME` varchar(30) DEFAULT NULL,
  `LASTNAME` varchar(30) DEFAULT NULL,
  `TELEPHONE` varchar(15) DEFAULT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  `CREATED` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4
```

Enable query logging:
```
SET global log_output = 'FILE';
SET global general_log_file='/tmp/mysql_general.log';
SET global general_log = 1;
```

Run webapp
```
java -jar jetty-runner-8.1.9.v20130131.jar /target/Spring3HibernateIntegration.war
```
