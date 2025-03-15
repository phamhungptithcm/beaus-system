# Use OpenJDK base image
FROM openjdk:17-jdk-slim AS build

# Set the working directory
WORKDIR /app

# Copy the Maven project descriptor (pom.xml)
COPY pom.xml .

# Download the dependencies to improve Docker build cache efficiency
RUN mvn dependency:go-offline -B

# Copy the source code to the working directory
COPY src ./src

# Build the application using Maven
RUN mvn clean package -DskipTests

# Use a smaller base image for running the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/auth-service-1.0.0.jar auth-service.jar

# Expose the application port
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "auth-service.jar"]
