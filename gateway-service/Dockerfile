FROM openjdk:17-jdk-slim

WORKDIR /gatewayservice

COPY gateway-service/target/gateway-service-0.0.1-SNAPSHOT.jar gatewayservice.jar
ENTRYPOINT ["java", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "gatewayservice.jar"]