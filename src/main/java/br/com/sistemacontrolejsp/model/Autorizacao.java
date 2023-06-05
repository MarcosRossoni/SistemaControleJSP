package br.com.sistemacontrolejsp.model;

import br.com.sistemacontrolejsp.enums.Sexo;
import lombok.Data;

@Data
public class Autorizacao {

    private Integer id;

    private String dsNome;

    private Integer idade;

    private Integer procedimento;

    private Sexo fgSexo;

    public Autorizacao() {
    }

    public Autorizacao(String dsNome, Integer idade, Integer procedimento, Sexo fgSexo) {
        this.dsNome = dsNome;
        this.idade = idade;
        this.procedimento = procedimento;
        this.fgSexo = fgSexo;
    }
}
