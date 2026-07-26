FROM maven:3.8.8-eclipse-temurin-21 AS build

WORKDIR /app

COPY . .

RUN mvn dependency:go-offline

COPY src /app/src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/usuario-0.0.1-SNAPSHOT-exec.jar app.jar