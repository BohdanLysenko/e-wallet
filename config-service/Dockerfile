FROM openjdk:17-jdk-slim

WORKDIR /configservice

COPY config-service/target/config-service-0.0.1-SNAPSHOT.jar configservice.jar

ENTRYPOINT ["java", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "configservice.jar"]