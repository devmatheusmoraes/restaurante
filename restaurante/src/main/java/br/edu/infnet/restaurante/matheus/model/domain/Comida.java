package br.edu.infnet.restaurante.matheus.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TComida")
public class Comida extends Produto{

    @Size(min = 3, max = 150, message = "O acompanhamento do produto deve ter entre {min} e {max} caracteres.")
    @Column(name = "dsacompanhamento")
    private String acompanhamento;

    @Max(value = 5)
    @Min(value = 1)
    @Column(name = "qtPessoas")
    private int serveQtdPessoas;

    public Comida(int codigo, String nome, float preco, boolean estoque, String acompanhamento, int serveQtdPessoas) {
        super(codigo, nome, preco, estoque);
        this.acompanhamento = acompanhamento;
        this.serveQtdPessoas = serveQtdPessoas;
    }

    @Override
    public String toString(){
        return String.format("%s - Acompanhamento: [%s] - Serve Quantidade Pessoas: %d }", super.toString(), this.getAcompanhamento(), this.getServeQtdPessoas());
    }

}
