package br.edu.infnet.restaurante.matheus.model.domain;

import br.edu.infnet.restaurante.matheus.dto.PedidoDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TPedido")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "cspedido")
    private int codigo;

    @NotBlank(message = "É necessário preencher o campo DESCRIÇÃO!")
    @Size(min = 3, max = 100, message = "O nome do pedido deve ter entre {min} e {max} caracteres.")
    private String descricao;

    @Column(unique = true)
    private int mesa;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco enderecoEntrega;

    @Column(name = "vlpedido")
    private float total;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idPedido")
    @JsonManagedReference
    private List<Produto> produtos;

    public Pedido() {
        this.produtos = new ArrayList<>();
        this.total = 0;
    }

    public Pedido(PedidoDTO dto){
        this.codigo = dto.codigo();
        this.descricao = dto.nome();
        this.mesa = dto.mesa();
        this.total = 0;
        this.produtos = new ArrayList<>();
    }

    @Override
    public String toString(){
        return String.format("Pedido { ID: %d - código: %d - nome: %s - Mesa: %d - Total: %.2f - Qtd Produtos: %d - Endereço: %s}",
                this.getId(),
                this.getCodigo(),
                this.getDescricao(),
                this.getMesa(),
                this.getTotal(),
                this.produtos.size(),
                this.getEnderecoEntrega()
        );
    }
}
