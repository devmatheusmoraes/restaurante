package br.edu.infnet.restaurante.matheus.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TBebida")
public class Bebida extends Produto{

    @Size(min = 2, max = 20, message = "A marca do produto deve ter entre {min} e {max} caracteres.")
    @Column(name = "dsmarca")
    private String marca;

    @NotNull(message = "O tamanho da bebida precisa ser informado.")
    private int tamanho;

    public Bebida(int codigo, String nome, float preco, boolean estoque, String marca, int tamanho) {
        super(codigo, nome, preco, estoque);
        this.marca = marca;
        this.tamanho = tamanho;
    }

    @Override
    public String toString(){
        return String.format("%s - Marca: %s - Tamanho ml: %d }", super.toString(), this.getMarca(), this.getTamanho());
    }

}
