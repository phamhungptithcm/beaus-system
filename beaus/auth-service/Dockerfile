# Stage 1: Build the application using Maven
FROM maven:3.8.6-eclipse-temurin-17 AS builder

# Set the working directory
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:17-jre-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar auth-serve-1.0.2.jar

# Expose the application port
EXPOSE 8080

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "auth-serve-1.0.2.jar"]
