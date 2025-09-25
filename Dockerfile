FROM amazoncorretto:25-alpine3.22
LABEL authors="hendisantika"

WORKDIR /app

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
