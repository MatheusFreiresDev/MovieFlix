# 🎬 MovieFlix

API REST para gerenciar filmes, categorias e serviços de streaming. Autenticação via JWT com Spring Security e backend em Java com PostgreSQL.

---

## 🚀 Tecnologias

- Java 17  
- Spring Boot  
- Spring Security  
- JWT (JSON Web Token)  
- PostgreSQL  
- Maven  

---

## ⚙ Funcionalidades

- Registro e login de usuários com JWT  
- CRUD completo de filmes  
- CRUD de categorias  
- CRUD de serviços de streaming  
- Proteção das rotas via autenticação  

---

## 📡 Endpoints

### Autenticação

| Método | Endpoint          | Descrição                     |
|--------|-------------------|------------------------------|
| POST   | `/auth/register`  | Registrar novo usuário         |
| POST   | `/auth/login`     | Login e obtenção do token JWT |

### Filmes

| Método | Endpoint           | Descrição                    |
|--------|--------------------|-----------------------------|
| GET    | `/movies`           | Listar todos os filmes       |
| GET    | `/movies/{id}`      | Buscar filme por ID          |
| POST   | `/movies`           | Criar novo filme             |
| PUT    | `/movies/{id}`      | Atualizar filme existente    |
| DELETE | `/movies/{id}`      | Deletar filme                |

### Categorias

| Método | Endpoint            | Descrição                    |
|--------|---------------------|-----------------------------|
| GET    | `/categories`        | Listar categorias            |
| POST   | `/categories`        | Criar nova categoria         |
| PUT    | `/categories/{id}`   | Atualizar categoria          |
| DELETE | `/categories/{id}`   | Deletar categoria            |

### Streamings

| Método | Endpoint            | Descrição                    |
|--------|---------------------|-----------------------------|
| GET    | `/streamings`        | Listar serviços de streaming |
| POST   | `/streamings`        | Criar novo serviço de streaming |
| PUT    | `/streamings/{id}`   | Atualizar serviço            |
| DELETE | `/streamings/{id}`   | Deletar serviço              |

---

## 👨‍💻 Contato

Matheus Freires — [GitHub](https://github.com/MatheusFreiresDev)

---

