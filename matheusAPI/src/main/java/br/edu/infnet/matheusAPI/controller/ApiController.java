package br.edu.infnet.matheusAPI.controller;

import br.edu.infnet.matheusAPI.model.domain.Endereco;
import br.edu.infnet.matheusAPI.model.domain.Estado;
import br.edu.infnet.matheusAPI.model.domain.Municipio;
import br.edu.infnet.matheusAPI.model.service.EnderecoService;
import br.edu.infnet.matheusAPI.model.service.LocalidadeService;
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

    @Autowired
    private LocalidadeService localidadeService;

    @GetMapping(value = "/estados")
    public Collection<Estado> obterEstados(){
        return localidadeService.obterEstados();
    }

    @GetMapping(value = "/{uf}/municipios")
    public Collection<Municipio> obterMunicipios(@PathVariable Integer uf){
        return localidadeService.obterMunicipios(uf);
    }

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep) {
        return enderecoService.obterPorCep(cep);
    }

}
