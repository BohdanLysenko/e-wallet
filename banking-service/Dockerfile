FROM openjdk:17-jdk-slim

WORKDIR /bankingservice

COPY banking-service/target/banking-service-0.0.1-SNAPSHOT.jar bankingservice.jar
ENTRYPOINT ["java", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "bankingservice.jar"]