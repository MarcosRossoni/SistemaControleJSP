# Sistema de Controle JSP
O projeto foi construído com JDK 17, sendo utilizado para build Maven para ser realizado o build, o banco de dados utilizado
foi o Postgres o mesmo rodando em container Docker em localhost, para as trativas de tela foi usado JSP e Servelets para
realizar as requisições necessárias, foi utilizado a dependência lombok possibilitando um código mais limpo, como servidor
foi usado o Jetty e para a estilização das telas foi utilizado bootstrap.

# Detalhamentos
O projeto funciona de maneira simples, inicialmente se deve criar uma base de dados no Postgres, com o nome de <b>sistema_autorizacao</b>,
após a criação dessa base de dados, se deve startar o projeto auxiliar que é responsável pelo gerenciamento do liquibase o mesmo
esta disponivel no reposositorio do link a seguir https://github.com/MarcosRossoni/controle-liquibase, as instruções para o
funcionamento do mesmo estão disponíveis em seu respectivo Readme.md.


Após as devidas tratativas, basta startar o projeto Sistema de Controle JSP com o comando <b>mvn jetty:run</b> e acessar 
http://localhost:8080/sistema-controle/pagina-inicial.html e escolher se deseja cadastrar um procedimento ou visualizar 
os que já estão cadastrados.
