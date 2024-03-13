FROM openjdk:23-slim-bullseye

WORKDIR /app

COPY ./target/sender.jar ./app/sender.jar

EXPOSE 9000

CMD ["java", "-jar", "./app/sender.jar"]