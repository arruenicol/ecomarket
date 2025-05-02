# Usa una imagen con Maven para la etapa dde construcción
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Directorio de trabajo
WORKDIR /app

# Copia primero el POM (esto permite cachear dependencias)
COPY pom.xml .

# Descarga dependencias (se cachean si el POM no cambia)
RUN mvn dependency:go-offline

# Copia todo el código fuente
COPY src src

# Compila el proyecto y crea el JAR
RUN mvn package -DskipTests

# Segunda etapa: imagen final más pequeña
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copia el JAR desde la etapa de construcción
COPY --from=builder /app/target/ecomarket-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=cloud"]