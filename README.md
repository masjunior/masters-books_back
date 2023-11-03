Para executar a aplicação é necessário "subir" o banco de dados e ter um banco com o nome mastersofbooks. 
Para executar os script através do flyway deve executar o comando:
    mvn flyway:migrate
Após este processo pode executar aplicação com o comando:
    mvn spring-boot:run