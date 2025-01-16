Aplicação de Gerenciamento de Tarefas 
📋 Descrição do Projeto
Sistema de gerenciamento de tarefas desenvolvido com Spring Boot e Java 21, seguindo os princípios SOLID. O sistema permite criar usuários, listas de tarefas e itens para cada lista.

📋 Tecnologias Utilizadas
Java 21
Spring Boot 3.2.2
Gradle
SQL Server
Lombok
JPA/Hibernate

📋 Funcionalidades
Gerenciamento de usuários
Criação de listas de tarefas
Adição de itens às listas
Marcação de itens como concluídos
Atualização e remoção de tarefas

📋 Endpoints da API
Usuários
POST /api/users - Criar novo usuário
GET /api/users - Listar todos usuários
GET /api/users/{id} - Buscar usuário por ID

Listas de Tarefas
POST /api/todo-lists/users/{userId} - Criar lista para um usuário
GET /api/todo-lists/{id} - Buscar lista por ID
GET /api/todo-lists/users/{userId} - Buscar listas de um usuário

Itens da Lista
POST /api/todo-lists/{todoListId}/items - Criar item em uma lista
GET /api/todo-lists/{todoListId}/items - Listar itens de uma lista
GET /api/todo-lists/{todoListId}/items/{id} - Buscar item específico
PUT /api/todo-lists/{todoListId}/items/{id} - Atualizar item
DELETE /api/todo-lists/{todoListId}/items/{id} - Remover item
PATCH /api/todo-lists/{todoListId}/items/{id}/toggle - Alternar status de conclusão

📋 Estrutura do Projeto
Copysrc/main/java/com/example/todo/
├── model/
│   ├── TodoUser.java
│   ├── TodoList.java
│   └── TodoItem.java
├── repository/
│   ├── TodoUserRepository.java
│   ├── TodoListRepository.java
│   └── TodoItemRepository.java
├── service/
│   ├── TodoUserService.java
│   ├── TodoListService.java
│   └── TodoItemService.java
└── controller/
    ├── TodoUserController.java
    ├── TodoListController.java
    └── TodoItemController.java

📋 Como Executar o Projeto

Clone o repositório
Configure o SQL Server conforme as propriedades acima
Execute o comando: ./gradlew bootRun
A API estará disponível em http://localhost:8080

📝 Exemplos de Requisições
Criar Usuário
jsonCopyPOST /api/users
{
    "username": "joao.silva",
    "email": "joao.silva@gmailx.com"
}
Criar Lista
jsonCopyPOST /api/todo-lists/users/1
{
    "title": "Compras do Mês",
    "description": "Lista de compras do supermercado"
}
Criar Item
jsonCopyPOST /api/todo-lists/1/items
{
    "title": "Comprar Leite",
    "description": "2 caixas de leite integral",
    "completed": false
}
