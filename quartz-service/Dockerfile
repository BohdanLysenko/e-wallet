# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /quartzservice

# Copy the project’s jar file to the container
COPY quartz-service/target/quartz-service-0.0.1-SNAPSHOT.jar quartzservice.jar
# Run the application
ENTRYPOINT ["java", "-Djasypt.encryptor.password=${JASYPT_ENCRYPTOR_PASSWORD}", "-jar", "quartzservice.jar"]