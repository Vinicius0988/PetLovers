README - Backend Pets (Spring Boot + MySQL)

====================================================
1. COMO CRIAR O BANCO DE DADOS NO MYSQL WORKBENCH
====================================================

Antes de rodar o projeto, abra o MySQL Workbench e execute o comando:

CREATE DATABASE IF NOT EXISTS pets
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

Isso garante que o banco "pets" exista para que o Spring Boot crie as tabelas automaticamente.


====================================================
2. CONFIGURAÇÃO DO APPLICATION.PROPERTIES
====================================================

O projeto já vem configurado assim:

spring.datasource.url=jdbc:mysql://localhost:3306/pets
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

O que isso significa?

- O banco de dados DEVE existir (comando acima).
- As tabelas serão criadas automaticamente pelo Hibernate.
- Alterações de entidades serão sincronizadas.


====================================================
3. COMO RODAR O PROJETO EM OUTRO COMPUTADOR
====================================================

1. Instale o MySQL (ou use Docker se preferir).
2. Abra o MySQL Workbench.
3. Execute:

CREATE DATABASE IF NOT EXISTS pets;

4. Ajuste usuário e senha no application.properties se forem diferentes.
5. Rode o backend com:

mvn spring-boot:run

Assim que o Spring iniciar, ele criará automaticamente todas as tabelas dentro do banco "pets".


====================================================
4. IMPORTAR E EXPORTAR O BANCO (OPCIONAL)
====================================================

Se quiser levar o banco com dados para outro PC, você pode exportar e importar.

EXPORTAR:
mysqldump -u root -p pets > backup.sql

IMPORTAR:
mysql -u root -p pets < backup.sql


====================================================
5. SOBRE O HIBERNATE
====================================================

- Ele cria TABELAS automaticamente.
- Ele NÃO cria o DATABASE (por isso o comando acima é obrigatório).
- Ao rodar o projeto pela primeira vez, se o banco estiver vazio:
  As tabelas serão criadas conforme suas entidades.


====================================================
6. TESTES COM INSOMNIA
====================================================

Após rodar o projeto, você pode testar usando:

GET  http://localhost:8080/pets
POST http://localhost:8080/pets
PUT  http://localhost:8080/pets/{id}
DELETE http://localhost:8080/pets/{id}

Exemplo de JSON para criar um PetDomestico:

{
  "title": "Cachorro",
  "peso": 10,
  "sexo": "Macho",
  "especie": "Mamífero",
  "image": "dog.jpg",
  "idade": 3,
  "raca": "Labrador",
  "licenca": null
}

Exemplo de JSON para criar um PetSelvagem:

{
  "title": "Arara Azul",
  "peso": 2,
  "sexo": "Fêmea",
  "especie": "Ave",
  "image": "arara.jpg",
  "idade": 5,
  "raca": null,
  "licenca": true
}


====================================================
PRONTO!
====================================================

Agora qualquer pessoa pode rodar o seu projeto em qualquer PC sem complicações.
