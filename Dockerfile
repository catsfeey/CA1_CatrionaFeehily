FROM tomcat:latest
ADD target/catrionaspetitions.war /usr/local/tomcat/webapps/
EXPOSE 8081
CMD ["catalina.sh", "run"]