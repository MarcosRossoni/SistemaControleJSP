package br.com.sistemacontrolejsp.controller;

import br.com.sistemacontrolejsp.connection.ConnectionFactory;
import br.com.sistemacontrolejsp.dao.AutorizacaoDAOImpl;
import br.com.sistemacontrolejsp.dto.AutorizacaoDTO;
import br.com.sistemacontrolejsp.enums.Sexo;
import br.com.sistemacontrolejsp.model.Autorizacao;

import java.net.HttpRetryException;
import java.sql.Connection;
import java.sql.SQLException;

public class AutorizacaoController {

    Connection connection = ConnectionFactory.getConnection();

    public void verificaAutorizacao(AutorizacaoDTO autorizacaoDTO) throws SQLException {

        if (autorizacaoDTO.getProcedimento().equals(1234) && autorizacaoDTO.getIdade().equals(10)
                && autorizacaoDTO.getFgSexo().equals(Sexo.FEMININO.ordinal())){
            cadastrarAutorizacao(autorizacaoDTO);
            return;
        }

        if (autorizacaoDTO.getProcedimento().equals(4567) && autorizacaoDTO.getIdade().equals(20)
                && autorizacaoDTO.getFgSexo().equals(Sexo.MASCULINO.ordinal())){
            cadastrarAutorizacao(autorizacaoDTO);
            return;
        }

        if (autorizacaoDTO.getProcedimento().equals(6789) && autorizacaoDTO.getIdade().equals(10)
                && autorizacaoDTO.getFgSexo().equals(Sexo.MASCULINO.ordinal())){
            cadastrarAutorizacao(autorizacaoDTO);
            return;
        }

        if (autorizacaoDTO.getProcedimento().equals(1234) && autorizacaoDTO.getIdade().equals(20)
                && autorizacaoDTO.getFgSexo().equals(Sexo.MASCULINO.ordinal())){
            cadastrarAutorizacao(autorizacaoDTO);
            return;
        }

        if (autorizacaoDTO.getProcedimento().equals(4567) && autorizacaoDTO.getIdade().equals(30)
                && autorizacaoDTO.getFgSexo().equals(Sexo.FEMININO.ordinal())){
            cadastrarAutorizacao(autorizacaoDTO);
            return;
        }

        try {
            throw new HttpRetryException("Procedimento Invalido para este paciente", 404);
        } catch (HttpRetryException e) {
            throw new RuntimeException(e);
        }
    }

    private void cadastrarAutorizacao(AutorizacaoDTO autorizacaoDTO) throws SQLException {
        Autorizacao autorizacao = new Autorizacao(
                autorizacaoDTO.getDsNome(),
                autorizacaoDTO.getIdade(),
                autorizacaoDTO.getProcedimento(),
                Sexo.values()[autorizacaoDTO.getFgSexo()]
        );

        AutorizacaoDAOImpl dao = new AutorizacaoDAOImpl(connection);
        dao.save(autorizacao);

        connection.close();
    }
}
