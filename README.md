# Bem vindos ao teste técnico da Attornatus!

Autor: Otávio Luiz Nunes Valadão

## Para acessar o banco H2 :
- Acesso ao [Banco H2](http://localhost:8080/h2)
- Login: admin
- Senha: 123
---
## A arquitetura foi montada da seguinte maneira:
- Pastas para Configurações, Domínio, Controladora, Repositório, Serviços e DTOs. Tudo isso prevendo uma melhor forma de manutenção do condigo e facilidade de acesso as entidades/classes;
- As configurações do sistema, na totalidade estão separadas num pacote para melhor manutenção. Como, por exemplo, o swagger, e pensando em sua escalabilidade, o próximo passo seria adicionar um cadastro de usuários.
- O Domínio foi criado seguindo POO (Programação Orientada a Objetos), contendo Atributos e modificadores de acesso, além disso, toda ORM (mapeamento objeto-relacional) utilizando os recursos do HIBERNATE e JPA;
- A Controladora seguindo os padrões de projeto segue contendo o CRUD do projeto. Todas com as devidas repostas com status HTTP;
- O Repositório, responsável por pela camada de persistência;
- Serviços segue para implementação de todas as regras de negócio da aplicação, salientando que toda ela foi montada, prevendo escalabilidade para futuras features;
- DTO's (Objeto de Transferência de Dados) seguindo mais uma vez os padrões de projeto, faz com que as informações trafeguem dentro da aplicação de forma mais eficiente.
---

## Para ajuda auxiliar a descrição, consumo e visualização de serviços da API temos o swagger:
- Acesso ao [swagger](http://localhost:8080/swagger-ui/index.html)
---

## Para facilitar o uso da aplicação caso queira usar o POSTMAN ou outro serviços que auxlia a testar APIs:

- Json POST/PUT Pessoa:
```
{
    "id":null,
    "cpf":784854,
    "name":"JOAO",
    "birthDate":"1998-12-12T03:00:00.000+00:00"
}
  ```
- Json POST/PUT Endereço:
```
{
    "id": null,
    "cep":1548784,
    "street":"R.01",
    "city":"MG/BH",
    "isMainAddress":false,
    "person_oid": 1
}
  ```
---