FROM alpine:3.15

RUN apk add openjdk11
COPY target/web_help_system-2.6.2.jar /app.jar


ENTRYPOINT ["java", "-jar", "/app.jar"]