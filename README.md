# 🧩 RBAC Users API

### Aplicação completa de Controle de Acesso Baseado em Papéis (RBAC) construída com Spring Boot + PostgreSQL + Docker Compose.

---

## 🚀 Como rodar o projeto

###### $ cd Rbac-Users/

### 1️⃣ Subir o banco de dados (PostgreSQL)
###### $ docker compose up --build -d
###
#### Verifique se o container está ativo:
######  $ docker ps

---

### 2️⃣ Rodar a aplicação Spring Boot
#### No IntelliJ / VSCode / terminal:
###### $ mvn spring-boot:run

###
#### A API será executada em:
##### http://localhost:8080

---

# 🧠 Estrutura do Banco
### O modelo segue o padrão RBAC (Role-Based Access Control):

 - ##### users — tabela de usuários
 - ##### roles — tabela de papéis (ex: ADMIN, EDITOR, VIEWER)
 - ##### permissions — permissões associadas aos papéis
 - ##### user_roles e role_permissions — tabelas de relacionamento N:N

---

## 🧩 Endpoints principais

Método | Rota | Descrição
-------|------|----------
POST   | /api/permissions | Cria uma permissão
GET    | /api/permissions | Lista todas as permissões
POST   | /api/roles       | Cria um papel (role) com permissões
GET    | /api/roles       | Lista papéis
POST   | /api/users       | Cria um usuário com papéis
GET    | /api/users       | Lista usuários
PUT    | /api/users/{id}  | Atualiza usuário
DELETE | /api/users/{id}  | Deleta usuário

---

## 🧪 Testando no Postman

### Importe o arquivo:
- ######  Rbac-Users.postman_collection.json

### Depois, siga a ordem de execução:

1. #### Criar Permissão
2. #### Criar Papel (Role)
3. #### Criar Usuário
4. #### Listar Usuários
5. #### Atualizar Usuário
6. #### Deletar Usuário

---

### 🧰 Tecnologias

- #### Java 17
- #### Spring Boot 3
- #### Spring Data JPA
- #### PostgreSQL 15 (Docker)
- #### Maven
- #### Lombok

---

# 👨‍💻 Autor
## Rafael Farsura
### RBAC Users - Java SpringBoot & SQL
