# Etapa 1: build da aplicação
FROM maven:3.9.6-eclipse-temurin-11 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

# Baixa as dependências e compila o projeto
RUN mvn clean package -DskipTests

# Etapa 2: runtime da aplicação
FROM eclipse-temurin:11-jdk
WORKDIR /app

# Copia o JAR gerado para o container final
COPY --from=build /app/target/*.jar app.jar

# Define a porta (importante para o Railway escutar)
EXPOSE 8080

# Comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "/app/camaraBack-0.0.1-SNAPSHOT.jar"]