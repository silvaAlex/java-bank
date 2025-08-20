# 🏦 Sistema Bancário em Java

Este projeto é uma aplicação **Java orientada a objetos**, desenvolvida para consolidar os principais conceitos da **Programação Orientada a Objetos (POO)**:

- ✅ Herança  
- ✅ Encapsulamento  
- ✅ Polimorfismo  
- ✅ Abstração  
- ✅ Reuso de código  
---

## 📌 Descrição

A aplicação simula um **sistema bancário básico**, oferecendo funcionalidades como:

- Criação de contas bancárias  
- Depósitos e saques  
- Transferências via **PIX**  
- Criação e gerenciamento de investimentos  
- Histórico de transações  

---

## 🎯 Objetivos do Projeto
- Demonstrar o uso de **POO** em Java
- Praticar conceitos avançados como **Enums** e **Records**
- Implementar repositórios em memória para persistência de dados
- Criar uma aplicação modular e escalável
- Facilitar a compreensão e manutenção do código
- Proporcionar uma base sólida para futuros projetos Java

## 🛠️ Tecnologias Utilizadas

- **Java 21**  
- **Lombok**  
- **Maven ou Gradle** (para build e dependências)  
- **Enums e Records**  
- Persistência em memória (repositórios simulados)  

---

## 🚀 Como Executar o Projeto

1. Clone este repositório:
```bash
   git clone https://github.com/silvaalex/java-bank.git
```
2. Acesse a pasta do projeto:
```bash
   cd java-bank
```
3. Compile e execute:
```bash
    # Para Maven
   ./mvnw clean install
   ./mvnw exec:java -Dexec.mainClass="br.com.dio.Main"
    # Para Gradle
   ./gradlew build
   ./gradlew run --args='br.com.dio.Main'
```
---
## 📖  Estrutura do Projeto
```plaintext
java-bank/
├── src/
src/
 ├── main/java/br/com/dio/
 │    ├── model/        # Entidades (Conta, Cliente Investimento, etc.)
 │    ├── repository/   # Repositórios em memória
 │    ├── service/      # Regras de negócio (saque, depósito, PIX, etc.)
 │    └── Main.java     # Ponto de entrada da aplicação
 └── test/java/...      # Testes unitários
├── build.gradle
├── settings.gradle
├── pom.xml
└── README.md
```
---
## 📚 Exemplos de Uso
- Criar conta bancária pelo console
- Realizar depósito e saque
- Efetuar transferência via PIX
- Investir em produtos simulados
- Consultar histórico de operações

