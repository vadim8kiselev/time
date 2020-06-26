FROM openjdk:8-jdk-alpine

ARG WAR_FILE=target/*.war

COPY ${WAR_FILE} application.war

ENTRYPOINT ["java","-jar","/application.jar"]