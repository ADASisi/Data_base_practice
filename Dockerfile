FROM ubuntu:latest
LABEL authors="silvi"

FROM adoptopenjdk:11-jre-hotspot

WORKDIR /app

COPY target/your-application.jar /app

EXPOSE 8080

CMD ["java", "-jar", "your-application.jar"]

ENTRYPOINT ["top", "-b"]