FROM ubuntu:latest
LABEL authors="rafaelfarsura"

FROM maven:3.9.9-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

EXPOSE 8080

ENV SPRING_PROFILES_ACTIVE=docker

CMD mvn clean compile install spring-boot:run

