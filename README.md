# 📘 Sistema de Cadastro de Usuários

## Descrição

Aplicação desenvolvida em **Java 21** com **Spring Boot**, utilizando um banco de dados em memória.
O sistema implementa um **CRUD** completo (**Create, Read, Update, Delete**) para cadastro de Pessoa Física e Pessoa Jurídica.

### 🚀 Tecnologias Utilizadas
- ☕ Java 21

- 🌱 Spring Boot

- 🗃️ Banco de Dados em Memória (H2)

- 📦 Spring Data JPA

- 🐳 Docker

### 🧾 Sobre o Projeto

Este projeto tem como objetivo gerenciar cadastros de usuários, permitindo salvar, atualizar, consultar e remover registros de Pessoa Física e Pessoa Jurídica.
Os campos marcados com `*` são obrigatórios e validados na API. ✔️


### 🏢 Atributos da Pessoa Jurídica
| Campo               | Obrigatório | Descrição                                 |
| ------------------- | ----------- | ----------------------------------------- |
| Razão Social        | ⭐          | Nome jurídico da empresa                  |
| Nome Fantasia       | ❌           | Nome comercial                            |
| CNPJ                | ⭐           | Cadastro Nacional da Pessoa Jurídica      |
| Email               | ⭐           | Contato da empresa                        |
| Inscrição Municipal | ⭐           | Necessário se for emissor de **NFSe**     |
| Inscrição Estadual  | ⭐           | Necessário se for emissor de **NFe/NFCe** |
| Código do Município | ⭐           | Código IBGE                               |
| Nome do Município   | ❌           | Nome legível do município                 |
| UF                  | ⭐           | Unidade Federativa                        |
| Regime Tributário   | ⭐           | Ex.: Simples Nacional, Lucro Presumido    |

### 👤 Atributos da Pessoa Física
| Campo               | Obrigatório    | Descrição                                               |
| ------------------- | -------------- | ------------------------------------------------------- |
| Nome                | ⭐              | Nome completo da pessoa                                 |
| CPF                 | ⭐              | Cadastro de Pessoa Física                               |
| Email               | ⭐              | Contato do usuário                                      |
| Telefone            | ❌              | Número para contato                                     |
| Inscrição Estadual  | ⭐ (se emissor) | Necessário apenas se for emissor de **NFe/NFCe**        |
| Código do Município | ⭐              | Código IBGE do município                                |
| Nome do Município   | ❌              | Nome legível do município                               |
| UF                  | ⭐              | Unidade Federativa                                      |
| Regime Tributário   | ⭐              | Ex.: MEI, Autônomo, Simples Nacional (quando aplicável) |



## 🐳 Build e Publicação da Imagem Docker

Este projeto utiliza **Docker** para empacotar e executar a aplicação Java de forma padronizada e portátil.

### 🔹 Pré-requisitos
- Docker instalado
- Conta no [Docker Hub](https://hub.docker.com)
- Projeto configurado e com `Dockerfile` na raiz

---

### 1️⃣ Build da imagem Docker

Na raiz do projeto, execute o comando abaixo para gerar a imagem Docker:

```bash
sudo docker build -t cadastro-usuario:0.0.2-RELEASE .
```
### 2️⃣ Enviar a imagem para o DockerHub

Faça login no Docker Hub pelo terminal:
```bash
sudo docker login
```
O padrão de nomenclatura exigido pelo Docker Hub é:

```bash
<usuario>/<repositorio>:<versao>
```
Exemplo:
```bash
sudo docker tag nome-arquivo:0.0.2-RELEASE seuUsuario/imagem-nome-arquivo:0.0.2-RELEASE
```
Após criar a tag, envie a imagem para o Docker Hub:
```bash
sudo docker push seu-usuario/imagem-nome-arquivo:0.0.2-RELEASE
```
Para executar a aplicação a partir da imagem publicada:
```bash
docker run -p 8080:8080 seu-usuario/imagem-nome-arquivo:0.0.2-RELEASE
```
### Como excutar a imagem deste projeto?

1. Copiar a imagem docker para sua máquina:
```bash
docker pull miqueias360/imagem-cadastro-user:0.0.4-RELEASE
```
2. Executar o projeto:
```bash
docker run -p 8080:8080 miqueias360/imagem-cadastro-user:0.0.4-RELEASE
```

### Acesso à documentação da API

- `http://localhost:8080/swagger-ui/index.html`

Próximas melhorias no projeto...



