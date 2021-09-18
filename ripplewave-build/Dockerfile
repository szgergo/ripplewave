FROM openjdk:11.0.12-jre-slim

RUN mkdir /app
WORKDIR app
COPY target/ripplewave-build-*.jar app.jar

RUN adduser --disabled-password ripplewave
USER ripplewave

CMD ["java", "-jar","app.jar"]