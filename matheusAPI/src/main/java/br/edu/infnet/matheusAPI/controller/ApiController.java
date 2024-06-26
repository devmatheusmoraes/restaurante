package br.edu.infnet.matheusAPI.controller;

import br.edu.infnet.matheusAPI.model.domain.Endereco;
import br.edu.infnet.matheusAPI.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RestController
public class ApiController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value = "/listagem")
    public Collection<String> obterLista(){
        return new ArrayList<String>(
                Arrays.asList("Teste", "Link", "API", "Rest")
        );
    }

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep) {
        Endereco endereco = enderecoService.obterPorCep(cep);
        return endereco;
    }

}
