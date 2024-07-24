FROM openjdk:17-jdk-alpine

COPY target/*.jar ./app/unity_java.jar

ENTRYPOINT ["java","-jar","/app/unity_java.jar"]
