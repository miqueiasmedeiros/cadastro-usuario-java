# -----------------------------
# Etapa 1 — Build
# -----------------------------
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .
COPY src ./src

RUN ./mvnw clean package -DskipTests

# -----------------------------
# Etapa 2 — Runtime
# -----------------------------
FROM eclipse-temurin:21-jre

LABEL maintainer="miqueiascompany@gmail.com"
WORKDIR /app

COPY --from=build /app/target/*jar cadastro-docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "cadastro-docker.jar"]
