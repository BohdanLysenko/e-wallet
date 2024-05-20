# Use a base image with Java 17 installed
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Java application (e.g., JAR file) into the container
COPY userservice/target/userservice-0.0.1-SNAPSHOT.jar userservice.jar

# Expose any ports your application may listen on
EXPOSE 8080

# Command to run the Java application
CMD ["java", "-jar", "userservice.jar"]
