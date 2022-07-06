FROM openjdk:11
ADD target/springboot-mongo-docker.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

