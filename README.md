# 📘 Sistema de Cadastro de Usuários

## Descrição

Aplicação desenvolvida em **Java 21** com **Spring Boot**, utilizando um banco de dados em memória.
O sistema implementa um **CRUD** completo (**Create, Read, Update, Delete**) para cadastro de Pessoa Física e Pessoa Jurídica.

### 🚀 Tecnologias Utilizadas
- ☕ Java 21

- 🌱 Spring Boot

- 🗃️ Banco de Dados em Memória (H2)

- 📦 Spring Data JPA

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


    
## Continua...