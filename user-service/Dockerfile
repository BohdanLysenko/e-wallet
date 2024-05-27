FROM openjdk:17-jdk-slim

WORKDIR /userservice

COPY user-service/target/user-service-0.0.1-SNAPSHOT.jar userservice.jar
ENTRYPOINT ["java", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "userservice.jar"]