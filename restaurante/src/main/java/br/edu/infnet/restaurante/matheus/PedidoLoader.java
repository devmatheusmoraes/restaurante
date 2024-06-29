package br.edu.infnet.restaurante.matheus;

import br.edu.infnet.restaurante.matheus.model.domain.*;
import br.edu.infnet.restaurante.matheus.model.service.ApiService;
import br.edu.infnet.restaurante.matheus.model.service.EnderecoService;
import br.edu.infnet.restaurante.matheus.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

@Component
public class PedidoLoader implements ApplicationRunner {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ApiService apiService;

    Pedido pedido = null;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/Pedido.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        while (linha != null){

            campos = linha.split(";");

            switch (campos[0].toUpperCase()){

                case "PEDIDO":

                    Endereco endereco = apiService.obterPorCep(campos[5]);

                    Celular celular = apiService.obterCelularPorNumero(campos[6]);

                    this.pedido = new Pedido();
                    pedido.setCodigo(Integer.parseInt(campos[1]));
                    pedido.setDescricao(campos[2]);
                    pedido.setMesa(Integer.parseInt(campos[3]));
                    pedido.setTotal(Float.parseFloat(campos[4]));
                    pedido.setEnderecoEntrega(endereco);
                    pedido.setCelularEntrega(Optional.ofNullable(celular).map(Celular::getFormat_national).orElse(""));

                    pedidoService.incluir(pedido);

                    break;
                case "COMIDA":

                    Comida comida = new Comida();
                    comida.setCodigo(Integer.parseInt(campos[1]));
                    comida.setDescricao(campos[2]);
                    comida.setPreco(Float.parseFloat(campos[3]));
                    comida.setEstoque(Boolean.parseBoolean(campos[4]));
                    comida.setAcompanhamento(campos[5]);
                    comida.setServeQtdPessoas(Integer.parseInt(campos[6]));

                    pedido.getProdutos().add(comida);

                    break;
                case "BEBIDA":

                    Bebida bebida = new Bebida();
                    bebida.setCodigo(Integer.parseInt(campos[1]));
                    bebida.setDescricao(campos[2]);
                    bebida.setPreco(Float.parseFloat(campos[3]));
                    bebida.setEstoque(Boolean.parseBoolean(campos[4]));
                    bebida.setMarca(campos[5]);
                    bebida.setTamanho(Integer.parseInt(campos[6]));

                    pedido.getProdutos().add(bebida);

                    break;
                default:

                    System.out.println("Pedido não encontrado");
                    break;
            }

            linha = leitura.readLine();
        }

        System.out.println("Iniciando Pedido Processamento");

        for(Pedido pedido : pedidoService.obterLista()){
            System.out.println(pedido);
        }

        System.out.println("Fim Pedido Processamento");

        leitura.close();
    }
}
