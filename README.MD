# Serviço de Elegibilidade de Cartões de Crédito

Este projeto implementa um serviço para determinar quais tipos de cartão de crédito um cliente pode obter com base em sua renda e histórico de crédito.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Maven**
- **JUnit 5**
- **Mockito**
- **Lombok**

## Padrões de Design Utilizados
- **Arquitetura em Camadas**: O projeto é estruturado em camadas (Controller, Service e Repository) para melhor organização e manutenção do código.
- **Dependency Injection**: Utiliza o Spring Framework para injeção de dependências e inversão de controle.
- **DTOs (Data Transfer Objects)**: Utilizados para transferência de dados entre camadas sem expor diretamente as entidades do banco de dados.

## Regras de Elegibilidade
O serviço determina a elegibilidade do cliente para os seguintes cartões:

- **Cartão Básico**: Disponível para clientes com renda até R$ 2.000 e score de crédito acima de 500.
- **Cartão Gold**: Disponível para clientes com renda entre R$ 2.000 e R$ 5.000 e score acima de 600.
- **Cartão Platinum**: Disponível para clientes com renda acima de R$ 5.000 e score acima de 750.

## Exemplo de Uso
### Requisição HTTP:
```
POST /customer-credit-cards
Content-Type: application/json

{
    "name": "Carlos Ferreira",
    "cpf": "123.456.789-00",
    "income": 4500.00,
    "credit_score": 650
}
```

### Resposta HTTP:
```
HTTP/1.1 200 OK
Content-Type: application/json

{
    "customer": "Carlos Ferreira",
    "credit_cards": [
        { "type": "BASIC" },
        { "type": "GOLD" }
    ]
}
```

## Testes Unitários
O projeto conta com testes unitários para garantir o correto funcionamento da lógica de elegibilidade dos cartões. Foram utilizados **JUnit 5** e **Mockito** para mockar dependências e simular diferentes cenários de validação.

## Como Executar o Projeto
1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-repositorio.git
   ```
2. Navegue até o diretório do projeto:
   ```sh
   cd credit-card-service
   ```
3. Compile e execute o projeto:
   ```sh
   mvn spring-boot:run
   ```

O serviço estará disponível em `http://localhost:8080`.

## Contato
Desenvolvido por **Ednilson Chiziane**. Para dúvidas ou sugestões, entre em contato pelo e-mail **seu-email@email.com**.

