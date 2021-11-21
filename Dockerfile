
FROM adoptopenjdk:11-jre-hotspot
MAINTAINER manuelzambrano.com
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} InterestService-0.0.1.war
ENTRYPOINT ["java","-jar","/InterestService-0.0.1.war"]