# VivaPlus Project

Este é um projeto Java de exemplo que utiliza Maven para gerenciamento de dependências e build. O projeto implementa operações de CRUD para gerenciamento de produtos (no caso, medicamentos) usando JDBC para interagir com o banco de dados.

## Tecnologias Utilizadas

- **Java** – Linguagem de programação principal.
- **Maven** – Gerenciamento de dependências e build.
- **JDBC** – Conexão com o banco de dados.
- **JUnit** – Execução de testes unitários (se aplicável).

## Organização do Projeto

- `src/main/java` – Contém o código-fonte da aplicação, incluindo DAOs, models, enumeradores e outras classes de lógica de negócio.
- `src/test/java` – Contém os testes unitários para as classes do projeto.

## Estrutura de Pacotes Importantes

- `org.vivaplus.model.dao` – Contém o `DrugDAO` para operações de acesso aos dados.
- `org.vivaplus.model.enums` – Contém os enumeradores, como `Prescription` e possivelmente outros que representem estados ou configurações.
- `org.vivaplus.model.bean` – Contém as classes de modelo (como `Drug` e `User`) que representam os dados da aplicação.

## Funcionalidades Principais

- **CRUD de Produtos:** Criação, leitura, atualização e remoção de registros de produtos.
- **Integração com Banco de Dados:** Uso de conexões JDBC para persistência e recuperação dos dados.
- **Enumerações para Controle:** Uso de enumeradores, como o `Prescription`, para padronizar valores.

## Configuração e Execução

1. **Clonar o Repositório:**  
   Clone o repositório em sua máquina.

2. **Build com Maven:**  
   Navegue até a raiz do projeto e execute:
   ```shell
   mvn clean install
---
## Banco de Dados - Script SQL

```sql
-- Cria o banco de dados
CREATE DATABASE mydb;

-- Usa o banco criado
USE mydb;

-- Cria a tabela users com a coluna cip de 8 dígitos única
CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    cip VARCHAR(8) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('BASIC','ADMIN','MANAGER') DEFAULT 'BASIC',
    PRIMARY KEY (id)
);

-- Cria a tabela products com a coluna last_modified_by como chave estrangeira
CREATE TABLE products (
    product_id INT NOT NULL AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    product_quantity INT NOT NULL,
    product_price DECIMAL(10,2) NOT NULL,
    product_prescription ENUM('YES', 'NO') NOT NULL,
    product_batch VARCHAR(12) NOT NULL,
    product_batch_expiration DATE,
    last_modified_by INT,
    PRIMARY KEY (product_id),
    FOREIGN KEY (last_modified_by) REFERENCES users(id)
);

-- Insere usuários com cip de 8 dígitos
INSERT INTO users (name, cip, password, role)
VALUES
    ('Felipe Couto', '80900001', '123', 'BASIC');

-- Insere produtos (ainda sem modificador, pode ser NULL inicialmente)
INSERT INTO products (
    product_name,
    product_quantity,
    product_price,
    product_prescription,
    product_batch,
    product_batch_expiration
)
VALUES
    ('Paracetamol 500mg', 100, 5.99, 'NO', 'LoteP001', '2026-12-31');

-- Consulta para verificar os dados, incluindo quem modificou
SELECT
    p.product_id,
    p.product_name,
    p.product_quantity,
    p.product_price,
    p.product_prescription,
    p.product_batch,
    p.product_batch_expiration,
    u.name AS last_modified_by
FROM products p
LEFT JOIN users u ON p.last_modified_by = u.id;

-- Consulta de todos os usuários
SELECT * FROM users;

    
