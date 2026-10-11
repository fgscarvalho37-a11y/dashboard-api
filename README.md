# Sales Dashboard API

> Back-end de demonstração para registrar vendas e gerar indicadores de desempenho comercial.

**Stack:** Java 21 · Spring Boot 3 · Spring Data JPA · H2 · Maven  
**Status:** Projeto de estudo / portfólio

## Funcionalidades

- CRUD básico de registros de vendas
- Resumo com receita, quantidade e ticket médio
- Agregação por categoria e por data
- Consumo por interface web separada

## Endpoints principais

| Método | Rota | Objetivo |
|---|---|---|
| `GET` | `/api/sales` | Lista vendas |
| `GET` | `/api/sales/summary` | Retorna indicadores |
| `GET` | `/api/sales/by-category` | Agrega por categoria |
| `GET` | `/api/sales/by-date` | Agrega por data |
| `POST` | `/api/sales` | Registra venda |
| `DELETE` | `/api/sales/{id}` | Remove venda |

## Executar localmente

Requisitos: **JDK 21** e conexão com o banco configurada conforme `src/main/resources/application.properties`.

```bash
git clone https://github.com/fgscarvalho37-a11y/dashboard-api.git
cd dashboard-api
./mvnw spring-boot:run
```

No Windows, utilize `mvnw.cmd spring-boot:run`. A porta e as propriedades de banco dependem da configuração da aplicação.

## Organização

`controller` recebe as requisições; `service` centraliza regras; `repository` acessa dados; `model` e `dto` representam entidades e dados de entrada/saída.

## Notas

Interface complementar: [dashboard-front](https://github.com/fgscarvalho37-a11y/dashboard-front). O front usa uma URL local que pode precisar de ajuste.

---

Desenvolvido por [Felipe Gomes](https://github.com/fgscarvalho37-a11y).