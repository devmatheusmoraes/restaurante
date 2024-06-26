package br.edu.infnet.restaurante.matheus.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TProduto")
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "csproduto")
    private int codigo;

    @NotBlank(message = "É necessário preencher o campo NOME!")
    @Column(name = "dsproduto")
    private String descricao;

    @Min(value = 1, message = "O preço do produto precisa ser maior ou igual a {value}")
    @Column(name = "vlproduto")
    private float preco;

    @Column(name = "flestoque")
    private boolean estoque;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    @JsonBackReference
    private Pedido pedido;

    public Produto(int codigo, String descricao, float preco, boolean estoque) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format("Produto { ID: %d - código: %d, nome: %s, preço: %.2f, Tem Estoque: %s",
                this.getId(),
                this.getCodigo(),
                this.getDescricao(),
                this.getPreco(),
                this.isEstoque() ? "Sim" : "Não");
    }
}
