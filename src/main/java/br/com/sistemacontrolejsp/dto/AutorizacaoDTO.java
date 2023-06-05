package br.com.sistemacontrolejsp.dto;

import lombok.Data;

@Data
public class AutorizacaoDTO {

    private Integer id;

    private String dsNome;

    private Integer idade;

    private Integer procedimento;

    private Integer fgSexo;

    public AutorizacaoDTO() {
    }

    public AutorizacaoDTO(String dsNome, Integer idade, Integer procedimento, Integer fgSexo) {
        this.dsNome = dsNome;
        this.idade = idade;
        this.procedimento = procedimento;
        this.fgSexo = fgSexo;
    }

    public AutorizacaoDTO(Integer id, String dsNome, Integer idade, Integer procedimento, Integer fgSexo) {
        this.id = id;
        this.dsNome = dsNome;
        this.idade = idade;
        this.procedimento = procedimento;
        this.fgSexo = fgSexo;
    }
}
