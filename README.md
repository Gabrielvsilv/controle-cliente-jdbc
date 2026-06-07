# Controle de Clientes JDBC

Projeto desenvolvido em Java com JDBC e PostgreSQL para gerenciamento de clientes através de um CRUD completo (Create, Read, Update e Delete).

## Objetivo

Este projeto foi desenvolvido com o objetivo de praticar conceitos de Java Back-End, Programação Orientada a Objetos (POO), JDBC e integração com banco de dados PostgreSQL através da implementação de um CRUD completo.

## Tecnologias Utilizadas

* Java
* JDBC
* PostgreSQL
* Programação Orientada a Objetos (POO)
* DAO (Data Access Object)
* Git
* GitHub

## Funcionalidades

* Cadastrar clientes
* Listar clientes
* Buscar cliente por ID
* Atualizar clientes
* Excluir clientes

## Estrutura do Projeto

```text
src/
 ├── Main.java
 └── model/
      ├── Pessoa.java
      └── Cliente.java

dao/
 └── ClienteDao.java

factory/
 └── ConnectionFactory.java
```

## Banco de Dados

Crie um banco de dados PostgreSQL com o nome:

```sql
CREATE DATABASE controle_cliente;
```

Crie a tabela:

```sql
CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);
```

## Configuração da Conexão

Antes de executar o projeto, edite o arquivo:

```java
factory/ConnectionFactory.java
```

Substitua os valores abaixo pelos dados do seu ambiente local:

```java
String url = "jdbc:postgresql://localhost:5432/controle_cliente";
String user = "SEU_USUARIO";
String password = "SUA_SENHA";
```

Exemplo:

```java
String url = "jdbc:postgresql://localhost:5432/controle_cliente";
String user = "postgres";
String password = "123456";
```

## Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/Gabrielvsilv/controle-cliente-jdbc.git
```

2. Configure o PostgreSQL em sua máquina.

3. Crie o banco de dados e a tabela conforme mostrado acima.

4. Atualize as credenciais no arquivo `ConnectionFactory.java`.

5. Adicione o driver JDBC do PostgreSQL ao projeto.

6. Execute a classe `Main.java`.

## Observação

O driver JDBC do PostgreSQL não está incluído neste repositório. É necessário baixar o driver compatível com sua versão do PostgreSQL e adicioná-lo ao projeto antes da execução.

## Conceitos Aplicados

* Encapsulamento
* Herança
* Construtores
* Collections (List)
* JDBC
* PreparedStatement
* ResultSet
* DAO Pattern
* CRUD
* Tratamento de Exceções

## Aprendizados

Durante o desenvolvimento deste projeto foram praticados conceitos fundamentais para aplicações Java Back-End:

* Conexão com banco de dados PostgreSQL
* Operações CRUD utilizando JDBC
* Separação de responsabilidades com DAO
* Modelagem orientada a objetos
* Herança entre classes
* Manipulação de listas de objetos
* Versionamento com Git
* Publicação de projetos no GitHub

## Autor

Gabriel Vieira

* Estudante de Análise e Desenvolvimento de Sistemas
* Focado em Java Back-End e Banco de Dados
* GitHub: https://github.com/Gabrielvsilv

