package br.com.sistemacontrolejsp.servlet;

import br.com.sistemacontrolejsp.controller.AutorizacaoController;
import br.com.sistemacontrolejsp.dto.AutorizacaoDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/autorizacao")
public class AutorizaçãoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AutorizacaoDTO autorizacaoDTO = new AutorizacaoDTO(
                null,
                request.getParameter("dsNome"),
                Integer.valueOf(request.getParameter("idade")),
                Integer.valueOf(request.getParameter("procedimento")),
                Integer.valueOf(request.getParameter("fgSexo"))
        );

        try {
            new AutorizacaoController().verificaAutorizacao(autorizacaoDTO);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/autorizacao-cadastrada.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
