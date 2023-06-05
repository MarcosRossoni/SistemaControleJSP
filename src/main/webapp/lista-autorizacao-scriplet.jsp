<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="br.com.sistemacontrolejsp.connection.ConnectionFactory" %>
<%@ page import="br.com.sistemacontrolejsp.dao.AutorizacaoDAOImpl" %>
<%@ page import="br.com.sistemacontrolejsp.dto.AutorizacaoDTO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt">
<style>
    @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400&display=swap');

    body {
        margin: 0px;
        border: 0px;
        font-family: 'Roboto', sans-serif;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Listagem Autorização</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="col-auto">
        <button class="btn btn-primary" aria-label="Voltar" onclick="window.location.href = 'pagina-inicial.html'">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
            </svg>
            <span>Voltar</span>
        </button>
    </div>
    <a class="navbar-brand" href="#">Lista Autorizações</a>
</nav>
<div class="container-fluid flex border border-dark p-3 my-3">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Cod</th>
            <th scope="col">Nome</th>
            <th scope="col">Idade</th>
            <th scope="col">Procedimento</th>
            <th scope="col">Sexo</th>
        </tr>
        </thead>
        <%
            Connection connection = ConnectionFactory.getConnection();
            AutorizacaoDAOImpl autorizacaoDAO = new AutorizacaoDAOImpl(connection);
            List<AutorizacaoDTO> listAutorizacao = autorizacaoDAO.findAll();

            for (AutorizacaoDTO autorizacao : listAutorizacao) {
                String dsSexo = autorizacao.getFgSexo() == 0 ? "Masculino" : "Feminino";
        %>
        <tbody>
        <tr>
            <td><%= autorizacao.getId()%></td>
            <td><%= autorizacao.getDsNome()%></td>
            <td><%= autorizacao.getIdade()%></td>
            <td><%= autorizacao.getProcedimento()%></td>
            <td><%= dsSexo%></td>
        </tr>
        </tbody>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
