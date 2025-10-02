# 🛍️ Loja Virtual - API de Produtos

API REST para cadastro e gerenciamento de produtos de uma loja virtual, desenvolvida com Spring Boot.

## 📋 Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

## 🚀 Como executar a aplicação

### 1. Clone o repositório
```bash
git clone https://github.com/LuigiBerzaghi/loja-virtual-api.git
cd loja-virtual-api/loja
```

### 2. Compile o projeto
```bash
mvn clean compile
```

### 3. Execute a aplicação
```bash
mvn spring-boot:run
```

### 4. Acesse a aplicação
A aplicação estará disponível em: http://localhost:8080

## 🗄️ Banco de Dados

A aplicação utiliza **H2 Database** (banco em memória) com **Flyway** para migrações automáticas.

### Migrações executadas automaticamente:
- **V1**: Criação da tabela `produto`
- **V2**: Adição da coluna `categoria`
- **V3**: Inserção de dados iniciais (5 produtos)

### Console H2 (opcional)
- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: *(deixar em branco)*

## 📚 Endpoints da API

### 📋 Listar todos os produtos
```http
GET /produtos
```

**Resposta:**
```json
[
  {
    "id": 1,
    "nome": "Notebook Dell Inspiron",
    "descricao": "Notebook Dell com 8GB RAM e 256GB SSD",
    "preco": 2499.99
  },
  {
    "id": 2,
    "nome": "Mouse Logitech MX Master",
    "descricao": "Mouse sem fio ergonômico para produtividade",
    "preco": 299.9
  },
  {
    "id": 3,
    "nome": "Cadeira Gamer RGB",
    "descricao": "Cadeira gamer com iluminação RGB e apoio lombar",
    "preco": 899
  },
  {
    "id": 4,
    "nome": "Teclado Mecânico RGB",
    "descricao": "Teclado mecânico com switches blue e RGB",
    "preco": 349.99
  },
  {
    "id": 5,
    "nome": "Monitor 24 polegadas",
    "descricao": "Monitor Full HD 24 polegadas IPS",
    "preco": 599.99
  }
]
```

### 🔍 Buscar produto por ID

```http
GET /produtos/{id}
```

**Exemplo:**

```bash
curl http://localhost:8080/produtos/1
```

**Resposta (200 OK):**

```json
{
  "id": 1,
  "nome": "Notebook Dell Inspiron",
  "descricao": "Notebook Dell com 8GB RAM e 256GB SSD",
  "preco": 2499.99,
  "categoria": "Eletrônicos"
}
```

**Resposta (404 Not Found):** Produto não encontrado

### ➕ Criar novo produto

```http
POST /produtos
Content-Type: application/json
```

**Body:**
```json
{
  "nome": "Produto Teste",
  "descricao": "Descrição do produto teste",
  "preco": 99.99,
  "categoria": "Categoria Teste"
}
```

**Exemplo com curl:**

```bash
curl -X POST http://localhost:8080/produtos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Produto Teste",
    "descricao": "Descrição do produto teste",
    "preco": 99.99,
    "categoria": "Categoria Teste"
  }'
```

**Resposta (200 OK):**
```json
{
  "id": 6,
  "nome": "Produto Teste",
  "descricao": "Descrição do produto teste",
  "preco": 99.99,
  "categoria": "Categoria Teste"
}
```
## Testes via Postman
Para testar os endpoints acima, basta abrir o workspace: [aqui](https://www.postman.com/bold-zodiac-707210/workspace/cp5/collection/39387306-a6f8499e-0956-4b84-8e4c-ffc3d7fca370?action=share&source=copy-link&creator=39387306)

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/fiap/loja/
│   │   ├── controller/
│   │   │   └── ProdutoController.java    # Endpoints REST
│   │   ├── model/
│   │   │   └── Produto.java              # Entidade JPA
│   │   ├── repository/
│   │   │   └── ProdutoRepository.java    # Repository JPA
│   │   └── LojaApplication.java          # Classe principal
│   └── resources/
│       ├── db/migration/                 # Scripts Flyway
│       │   ├── V1__Create_products_table.sql
│       │   ├── V2__Add_category_to_products.sql
│       │   └── V3__Insert_initial_products.sql
│       └── application.properties        # Configurações
└── test/
    └── java/com/fiap/loja/
        └── LojaApplicationTests.java     # Testes
```

## 🛠️ Tecnologias Utilizadas

- **Spring Boot 3.4.11** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST
- **H2 Database** - Banco de dados em memória
- **Flyway** - Migrações de banco de dados
- **Maven** - Gerenciamento de dependências

## 📊 Dados Iniciais

A aplicação vem com 5 produtos pré-cadastrados:

1. **Notebook Dell Inspiron** - R$ 2.499,99 (Eletrônicos)
2. **Mouse Logitech MX Master** - R$ 299,90 (Eletrônicos)
3. **Cadeira Gamer RGB** - R$ 899,00 (Móveis)
4. **Teclado Mecânico RGB** - R$ 349,99 (Eletrônicos)
5. **Monitor 24 polegadas** - R$ 599,99 (Eletrônicos)

## 🧪 Testando a API

### Usando curl:
```bash
# Listar produtos
curl http://localhost:8080/produtos

# Buscar produto específico
curl http://localhost:8080/produtos/1

# Criar novo produto
curl -X POST http://localhost:8080/produtos \
  -H "Content-Type: application/json" \
  -d '{"nome":"Smartphone","descricao":"Smartphone Android","preco":899.99,"categoria":"Eletrônicos"}'
```

---

### Integrantes:

- RM555516 - Luigi Berzaghi
