#Step 1: Build jar using Maven
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests
 
#Step 2: RUN jar. Use Java 21 (recommended tor Spring Boot 3)
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar file
COPY --from=build /app/target/*.jar app.jar

#Expose port (Render needs this)
EXPOSE 8080

# Run jar
ENTRYPOINT ["java","-jar","/app/app.jar"]