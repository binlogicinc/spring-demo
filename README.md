# spring-demo

SET global log_output = 'FILE';
SET global general_log_file='/tmp/mysql_general.log';
SET global general_log = 1;

Run
java -jar jetty-runner-8.1.9.v20130131.jar /target/Spring3HibernateIntegration.war
