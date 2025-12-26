# -----------------------------
# Etapa 1 — Build da aplicação
# -----------------------------
FROM eclipse-temurin:21-jdk AS build

LABEL maintainer="miqueiascompany@gmail.com"
WORKDIR /app



COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .
COPY src ./src

# Baixa dependências e empacota
RUN ./mvnw clean package

#Etapa 2 - Runtime (JRE)
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia somente o JAR gerado no build
COPY --from=build /app/target/*jar cadastro-docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "cadastro-docker.jar"]
