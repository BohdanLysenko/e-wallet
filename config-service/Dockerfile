# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /configservice

# Copy the project’s jar file to the container
COPY config-service/target/config-service-0.0.1-SNAPSHOT.jar configservice.jar

# Run the application
ENTRYPOINT ["java", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "configservice.jar"]