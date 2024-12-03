# API-DONATION

API-DONATION é uma aplicação Spring Boot para gerenciar doações, voluntários e abrigos. A aplicação permite criar, listar, atualizar e deletar doações, abrigos e voluntários.

## 📋 Funcionalidades

### Rotas principais

- **/donation**
  - `GET`: Lista todas as doações ou filtra por categoria.
  - `POST`: Cria uma nova doação.
  - `PATCH /{id}`: Atualiza uma doação existente.
  - `GET /{id}`: Busca uma doação pelo ID.
  - `DELETE /{id}`: Remove uma doação pelo ID.

Outras rotas semelhantes estão disponíveis para entidades relacionadas como voluntários e abrigos (volunteer e shelter).

---
Para rodar o projeto localmente, é necessário ter o Docker instalado. Feito isso, no diretório do mesmo, rode o seguinte comando:

```shell
docker compose up -d

```

Também é possível acessar a API hospeadada através do link:
https://api-donation-production.up.railway.app/

---

## 🛠️ Exemplos de Requisição

### Criar uma doação

**POST /donation**

```json
{
  "nome": "Roupas",
  "categoria": "Vestuário",
  "quantidade": 10,
  "dataValidade": "2024-12-31"
}

Resposta
{
  "id": 1,
  "nome": "Roupas",
  "categoria": "Vestuário",
  "quantidade": 10,
  "dataValidade": "2024-12-31"
}
```

### Consultar uma doação específica

**GET /donation{id}**

Resposta

```json
{
  "id": 1,
  "nome": "Roupas",
  "categoria": "Vestuário",
  "quantidade": 10,
  "dataValidade": ""
}
```

### Consultar todas as doações

**GET /donation**

Resposta

```json
[
  {
    "id": 1,
    "nome": "Roupas",
    "categoria": "Vestuário",
    "quantidade": 10,
    "dataValidade": ""
  },
  {
    "id": 2,
    "nome": "Cobertores",
    "categoria": "Utilitário",
    "quantidade": 1,
    "dataValidade": ""
  }
]
```

### Atualizar informações de uma doação

**PATCH /donation{$id}**

```json
{
  "nome": "Peças de roupa"
}
```

Resposta

```json
{
  "id": 1,
  "nome": "Peças de roupa",
  "categoria": "Vestuário",
  "quantidade": 10,
  "dataValidade": ""
}
```

### Deletar uma doação

**DELETE /donation/{$id}**

---

### Criar um abrigo

**POST /shelters**
```json
{
  "nome": "Abrigo São João",
  "endereco": "Rua das Flores, 123",
  "telefone": "1112345678",
  "capacidade": 50,
  "ocupacaoAtual": 30
}
```

Resposta: 

```json
{
  "id": 1,
  "nome": "Abrigo São João",
  "endereco": "Rua das Flores, 123",
  "telefone": "1112345678",
  "capacidade": 50,
  "ocupacaoAtual": 30
}
```

### Listar todos os abrigos

**GET /shelters**

Resposta:

```json
[
  {
    "id": 1,
    "nome": "Abrigo São João",
    "endereco": "Rua das Flores, 123",
    "telefone": "1112345678",
    "capacidade": 50,
    "ocupacaoAtual": 30
  }
]
```

### Atualizar um abrigo

**PUT /shelters/{$id}**
```json
{
  "nome": "Abrigo São João 2",
}
```

Resposta:

```json
{
  "id": 1,
  "nome": "Abrigo São João 2",
  "endereco": "Rua das Flores, 123",
  "telefone": "1112345678",
  "capacidade": 60,
  "ocupacaoAtual": 40
}
```

### Deletar um abrigo

**DELETE /shelters/{$id}**

---

### Criar um voluntário

**POST /volunteers**
```json
{
  "nome": "João Silva",
  "email": "joao.silva@gmail.com",
  "telefone": "1198765432",
  "habilidade": "Cozinheiro",
  "disponibilidade": "Manhã"
}
```

Resposta: 

```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@gmail.com",
  "telefone": "1198765432",
  "habilidade": "Cozinheiro",
  "disponibilidade": "Manhã"
}
```

### Listar todos os voluntários

**GET /volunteers**

Resposta:

```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao.silva@gmail.com",
    "telefone": "1198765432",
    "habilidade": "Cozinheiro",
    "disponibilidade": "Manhã"
  }
]
```

### Atualizar um voluntário

**PUT /volunteers/{$id}**
```json
{
  "nome": "João Gomes",
}
```

Resposta:

```json
{
  "id": 1,
  "nome": "João Gomes",
  "email": "joao.silva@gmail.com",
  "telefone": "1198765432",
  "habilidade": "Cozinheiro",
  "disponibilidade": "Manhã"
}
```

### Deletar um voluntário

**DELETE /volunteers/{$id}**


---

## 📄 Estrutura do Projeto

O projeto segue uma arquitetura em camadas, dividindo responsabilidades de maneira clara:

### Camadas principais

- **Controller:** Responsável por lidar com as requisições HTTP e retornar as respostas apropriadas. Exemplos:

  - `DonationController`
  - `VolunteerController`
  - `ShelterController`

- **Service:** Contém a lógica de negócios, implementando as operações sobre os dados. Exemplos:

  - `DonationService`
  - `VolunteerService`
  - `ShelterService`

- **Repository:** Interface para a comunicação com o banco de dados utilizando JPA. Exemplos:

  - `DonationRepository`
  - `VolunteerRepository`
  - `ShelterRepository`

- **Model:** Representa as entidades do banco de dados, incluindo suas anotações JPA. Exemplos:

  - `DonationModel`
  - `VolunteerModel`
  - `ShelterModel`

- **DTO e Mapper:** Gerenciam a transferência de dados e o mapeamento entre entidades e objetos DTO para simplificar a comunicação entre as camadas. Exemplos:
  - `DonationDTO` e `DonationMapper`
  - `VolunteerDTO` e `VolunteerMapper`
  - `ShelterDTO` e `ShelterMapper`

A estrutura garante modularidade, reutilização de código e facilidade de manutenção.
