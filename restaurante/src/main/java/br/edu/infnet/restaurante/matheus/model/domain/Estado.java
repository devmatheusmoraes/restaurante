package br.edu.infnet.restaurante.matheus.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estado {

    private Integer id;
    private String sigla;
    private String nome;

    public Estado() {
        this.setId(1);
    }

    public Estado(String sigla, String nome) {
        this();
        this.setSigla(sigla);
        this.setNome(nome);
    }

    @Override
    public String toString() {
        return String.format("%s [%s]", nome, sigla);
    }

}
