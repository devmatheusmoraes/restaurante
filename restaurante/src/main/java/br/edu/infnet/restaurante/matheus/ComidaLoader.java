package br.edu.infnet.restaurante.matheus;

import br.edu.infnet.restaurante.matheus.model.domain.Comida;
import br.edu.infnet.restaurante.matheus.model.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(Ordered.HIGHEST_PRECEDENCE + 1)
@Component
public class ComidaLoader implements ApplicationRunner {

    @Autowired
    private ComidaService comidaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/Comida.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        while (linha != null){

            campos = linha.split(";");

            Comida comida = new Comida();
            comida.setCodigo(Integer.parseInt(campos[0]));
            comida.setDescricao(campos[1]);
            comida.setPreco(Float.parseFloat(campos[2]));
            comida.setEstoque(Boolean.parseBoolean(campos[3]));
            comida.setAcompanhamento(campos[4]);
            comida.setServeQtdPessoas(Integer.parseInt(campos[5]));

            comidaService.incluir(comida);

            linha = leitura.readLine();
        }

        System.out.println("Iniciando Comida Processamento");

        for(Comida comida : comidaService.obterLista()){
            System.out.println(comida);
        }

        System.out.println("Fim Comida Processamento");

        leitura.close();
    }

}
