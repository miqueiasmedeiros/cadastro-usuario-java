#!/bin/sh

echo "⏳ Esperando o PostgreSQL iniciar..."

until nc -z postgres 5432; do
  sleep 2
done

echo "✅ PostgreSQL iniciado!"
echo "🚀 Iniciando aplicação..."

java -jar cadastro-docker.jar
