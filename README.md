# API-DONATION

API-DONATION é uma aplicação Spring Boot para gerenciar doações, voluntários e abrigos. A aplicação permite criar, listar, atualizar e deletar doações, além de realizar consultas por categorias.

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

## 🧪 Testando com Swagger

Esta API utiliza o Swagger para documentação interativa.

1. Após iniciar o projeto, acesse o Swagger UI:
   - **URL:** `http://localhost:8080/swagger-ui.html`

2. Explore e teste todas as rotas diretamente na interface Swagger, onde é possível visualizar a documentação completa e realizar chamadas às APIs com diferentes parâmetros.

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
