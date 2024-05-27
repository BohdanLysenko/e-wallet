# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /userservice

# Copy the project’s jar file to the container
COPY user-service/target/user-service-0.0.1-SNAPSHOT.jar userservice.jar
# Run the application
ENTRYPOINT ["java", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "userservice.jar"]