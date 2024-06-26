package br.edu.infnet.restaurante.matheus;

import br.edu.infnet.restaurante.matheus.model.domain.Bebida;
import br.edu.infnet.restaurante.matheus.model.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class BebidaLoader implements ApplicationRunner {

    @Autowired
    private BebidaService bebidaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("arquivos/Bebida.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        while (linha != null) {

            campos = linha.split(";");

            Bebida bebida = new Bebida();
            bebida.setCodigo(Integer.parseInt(campos[0]));
            bebida.setDescricao(campos[1]);
            bebida.setPreco(Float.parseFloat(campos[2]));
            bebida.setEstoque(Boolean.parseBoolean(campos[3]));
            bebida.setMarca(campos[4]);
            bebida.setTamanho(Integer.parseInt(campos[5]));

            bebidaService.incluir(bebida);

            linha = leitura.readLine();
        }

        System.out.println("Iniciando Bebida Processamento");

        for(Bebida bebida : bebidaService.obterLista()){
            System.out.println(bebida);
        }

        System.out.println("Fim Bebida Processamento");

        leitura.close();
    }
}
