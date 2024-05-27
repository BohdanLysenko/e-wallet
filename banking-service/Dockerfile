# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /bankingservice

# Copy the project’s jar file to the container
COPY banking-service/target/banking-service-0.0.1-SNAPSHOT.jar bankingservice.jar
# Run the application
ENTRYPOINT ["java", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "bankingservice.jar"]