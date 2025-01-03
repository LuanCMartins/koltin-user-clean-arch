FROM openjdk:23-jdk-slim

COPY target/shopping-customers-spring-config-1.0-SNAPSHOT-exec.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]