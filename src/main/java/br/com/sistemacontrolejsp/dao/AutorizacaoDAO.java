package br.com.sistemacontrolejsp.dao;

import br.com.sistemacontrolejsp.dto.AutorizacaoDTO;
import br.com.sistemacontrolejsp.model.Autorizacao;

import java.util.List;

public interface AutorizacaoDAO {

    Autorizacao save(Autorizacao autorizacao);

    List<AutorizacaoDTO> findAll();
}
