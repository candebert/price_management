FROM gradle:8.2.1-jdk17 AS builder

WORKDIR /app

COPY gradlew gradlew
COPY gradle /app/gradle
COPY build.gradle.kts settings.gradle /app/
COPY src /app/src

RUN chmod +x gradlew
RUN ./gradlew clean build --no-daemon

RUN ls -l build/libs/

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder app/build/libs/price_management-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
