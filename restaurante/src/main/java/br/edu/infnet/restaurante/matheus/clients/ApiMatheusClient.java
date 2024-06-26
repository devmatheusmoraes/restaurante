package br.edu.infnet.restaurante.matheus.clients;

import br.edu.infnet.restaurante.matheus.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "http://localhost:8081", value = "apiMatheus")
public interface ApiMatheusClient {
    @GetMapping(value = "/listagem")
    Collection<String> obterLista();

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep);

}
