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

WORKDIR /app

RUN apt-get update && apt-get install -y netcat-openbsd

COPY --from=build /app/target/*jar cadastro-docker.jar
COPY start.sh start.sh

RUN chmod +x start.sh

EXPOSE 8080

ENTRYPOINT ["./start.sh"]
