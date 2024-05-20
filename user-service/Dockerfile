# Use a base image with Java 17 installed
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Expose ports for MySQL connection and Java application
EXPOSE 8080
EXPOSE 3306

# Copy the compiled Java application (e.g., JAR file) into the container
COPY target/userservice-0.0.1-SNAPSHOT.jar /app/userservice.jar

# Command to run the Java application
CMD ["java", "-jar", "userservice.jar"]
