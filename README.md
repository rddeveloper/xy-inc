# Desafio Backend Zup - Teste Desenvolvedor 3

<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/gabrielmaximo/zup-xy-inc.svg">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/gabrielmaximo/zup-xy-inc.svg">

  <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
</p>

## :clipboard: Testando os serviços
* Realizar a chamada dos serviços. 
Para testar os serviços utilize um browser uma outra ferramenta como o Postman ou o Insomminia ou o proprio swagger que esta configurado na aplicação.
### :arrows_counterclockwise: Rota para cadastro de um novo produto
* ```http://localhost:8080/api/v1/products```
* POST
* Body Example:
* modelo de dados de exemplo apenas
```json
"name": "Produto 1",
"description": "Testando um novo Produto",
"price": 20,
"category": "Teste"
```
* Response Example:
```json
{
  "id": 1,
  "name": "Produto 1",
  "description": "Testando um novo Produto",
  "price": 20,
  "category": "Teste"
}
```

### :arrows_counterclockwise: Rota para listagem de todos os produtos cadastrados
* ```http://localhost:8080/api/v1/products```
* Get
* modelo de dados de exemplo apenas
```json
[
{
    "id": 1,
    "name": "Produto 1",
    "description": "Testando um novo Produto",
    "price": 20,
    "category": "Teste"
},
{
    "id": 2,
    "name": "Produto 2",
    "description": "Testando um segundo Produto",
    "price": 50,
    "category": "Teste"
}
    ...
]
```
  
### :arrows_counterclockwise: Rota para buscar produto cadastrado por id
* ```http://localhost:8080/api/v1/products/1```
* Get
* modelo de dados de exemplo apenas
```json
{
    "id": 1,
    "name": "Produto 1",
    "description": "Testando um novo Produto",
    "price": 20,
    "category": "Teste"
}
```

### :arrows_counterclockwise: Rota para atualizar produto cadastrado
* ```http://localhost:8080/api/v1/products/1```
* Put
* Body Example:
* modelo de dados de exemplo apenas
```json
"name": "Produto 1 Editado",
"description": "Testando um novo Produto Editado",
"price": 60,
"category": "Teste Editado"
```
* Esse endpoint não tem retorno (204-NO_CONTENT)

### :arrows_counterclockwise: Rota para deletar produto cadastrado
* ```http://localhost:8080/api/v1/products/1```
* Delete
* Esse endpoint não tem retorno (204-NO_CONTENT)


## Documentação Swagger

```sh
documentação dos serviços. URL http://localhost:8080/swagger-ui.html 

```

## Testes Unitários
* a aplicação esta configurada para realizar tests unitários, assim podendo realizar os testes mais precisos em cada método. A classe de exemplo (ProductRepositoryTest.java) esta dentro do package repository no diretório de test ```./src/test/java/com/zup/apitestedensevolvedor3/repository ```.
* com o uso do JUnit, é permitido testar o método diretamente, assim sendo muito mais rápido

* testando o metodo de salvar produto direto na camada de repository
  ```java
    @Test
    @Order(1)
    public void testProductSave() {
        Product product = new Product(null, "PRODUCT TEST1", "PRODUCT TESTING JUNIT", new BigDecimal(20), "TEST");
        Product response = productRepository.save(product);
        assertNotNull(response);
    }
  ```

* testando o metodo de listar todos os produtos direto na camada de repository
  ```java
    @Test
    @Order(2)
    public void testProductListAll() {
        List<Product> response = productRepository.findAll();
        assertFalse(response.isEmpty());
    }

  ```

* (Obs) se você acessar o diretório htt://localhost:8080, a aplicação esta configurada para leva-lo direto ao diretório base do swagger-ui.html.

## :warning: Dependências
* spring Boot Web
* JPA
* Postgres
* H2 Database
* Flyway
* SpringDoc OpenApi
* Junit
* ModelMapper
* DevTools
* OpenJDK

## :arrow_forward: Como executar o projeto?
* Primeiramente clone o projeto do [repositório](https://github.com/rddeveloper/xy-inc/), em seguida vá para o projeto clonado e instale as dependências( o projeto esta utilizando maven para centralizar a configuração das dependências), abra o projeto por alguma IDE( foi utilizado o IntelliJ IDEA (versão Ultimate Edition) para desenvolver a aplicação), rode o projeto pelo arquivo ApiTesteDesenvolvedor3Application.java que esta dentro de ```./src/main/java/com/zup/apitestedesenvolvedor3```. Simples assim!

## :floppy_disk: Base de Dados
* Foi utilizado Postgres como banco de dados junto com a ferramenta Flyway para fazer o controle de versionamento do mesmo, e o H2 para realizar os Testes Unitários para facilitar na hora de rodar o projeto localmente.
