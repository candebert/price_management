FROM openjdk:21-jdk
LABEL authors="CandelariaBertoldi"

WORKDIR /app

COPY build/libs/price_management-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
