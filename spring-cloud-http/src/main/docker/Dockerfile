#FROM openjdk:8-jre
FROM openjdk:8
VOLUME /temp
ADD spring-cloud-http-1.0-SNAPSHOT.jar spring-cloud-http.jar
ENTRYPOINT ["java" ,"-jar", "/spring-cloud-http.jar"]