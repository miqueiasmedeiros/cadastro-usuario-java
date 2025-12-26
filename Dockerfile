FROM eclipse-temurin:21
LABEL maintainer="miqueiascompany@gmail.com"
WORKDIR /app
COPY target/cadastro_usuario-0.0.1-SNAPSHOT.jar /app/cadastro-docker.jar
ENTRYPOINT ["java", "-jar", "cadastro-docker.jar"]
EXPOSE 8080