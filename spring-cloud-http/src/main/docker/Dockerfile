FROM openjdk:8
ADD ["spring-cloud-http-1.0-SNAPSHOT.jar","demo.jar"]
EXPOSE :8080
ENTRYPOINT ["java","-jar","/demo.jar"]