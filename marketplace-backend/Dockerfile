# Stage 1: Build the application using Gradle
FROM gradle:8.7-jdk21-jammy AS builder
WORKDIR /app
COPY . .

RUN ./gradlew bootJar --no-daemon

# Stage 2: Run the fat JAR using a lightweight runtime image (keeps it tiny)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8282
ENTRYPOINT ["java", "-jar", "app.jar"]