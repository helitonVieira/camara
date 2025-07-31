# Etapa 1: build da aplicação
FROM maven:3.9.6-eclipse-temurin-11 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: runtime da aplicação
FROM eclipse-temurin:11-jdk
WORKDIR /app

COPY --from=build /app/target/camaraBack-0.0.1-SNAPSHOT.jar camaraBack.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/camaraBack.jar"]