FROM openjdk:17-jdk-slim

WORKDIR /quartzservice

COPY quartz-service/target/quartz-service-0.0.1-SNAPSHOT.jar quartzservice.jar
ENTRYPOINT ["java", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "quartzservice.jar"]