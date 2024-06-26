package br.edu.infnet.restaurante.matheus;

import br.edu.infnet.restaurante.matheus.model.domain.Bebida;
import br.edu.infnet.restaurante.matheus.model.domain.Comida;
import br.edu.infnet.restaurante.matheus.model.service.BebidaService;
import br.edu.infnet.restaurante.matheus.model.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class ProdutoLoader implements ApplicationRunner {

    @Autowired
    private BebidaService bebidaService;

    @Autowired
    private ComidaService comidaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/Produto.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        System.out.println("Produtos:");

        while (linha != null){

            campos = linha.split(";");

            switch (campos[0].toUpperCase()){
                case "COMIDA":

                        Comida comida = new Comida();
                        comida.setCodigo(Integer.parseInt(campos[2]));
                        comida.setDescricao(campos[3]);
                        comida.setPreco(Float.parseFloat(campos[4]));
                        comida.setEstoque(Boolean.parseBoolean(campos[5]));
                        comida.setAcompanhamento(campos[6]);
                        comida.setServeQtdPessoas(Integer.parseInt(campos[7]));

                        comidaService.incluir(comida);

                        linha = leitura.readLine();
                    break;
                case "BEBIDA":

                        Bebida bebida = new Bebida();
                        bebida.setCodigo(Integer.parseInt(campos[2]));
                        bebida.setDescricao(campos[3]);
                        bebida.setPreco(Float.parseFloat(campos[4]));
                        bebida.setEstoque(Boolean.parseBoolean(campos[5]));
                        bebida.setMarca(campos[6]);
                        bebida.setTamanho(Integer.parseInt(campos[7]));

                        bebidaService.incluir(bebida);

                        linha = leitura.readLine();

                    break;
                default:
                        System.out.println("Produto não encontrado.");
                        linha = leitura.readLine();
                    break;
            }

        }

        System.out.println("Iniciando Produto Processamento");

        for(Comida comida : comidaService.obterLista()){
            System.out.println(comida);
        }
        for(Bebida bebida : bebidaService.obterLista()){
            System.out.println(bebida);
        }

        System.out.println("Fim Produto Processamento");

    }
}
