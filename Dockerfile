FROM openjdk:11
# run app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# if you've already overriden configuration settings via environment variables
ENTRYPOINT ["java","-jar","/app.jar"]