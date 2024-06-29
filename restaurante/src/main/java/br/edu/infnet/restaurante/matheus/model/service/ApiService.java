package br.edu.infnet.restaurante.matheus.model.service;

import br.edu.infnet.restaurante.matheus.clients.ApiMatheusClient;
import br.edu.infnet.restaurante.matheus.model.domain.Endereco;
import br.edu.infnet.restaurante.matheus.model.domain.Estado;
import br.edu.infnet.restaurante.matheus.model.domain.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Service
public class ApiService {
    @Autowired
    private ApiMatheusClient apiMatheusClient;
    public Endereco obterPorCep(String cep) {
        return apiMatheusClient.obterEnderecoPorCep(cep);
    }

    public Collection<Estado> obterEstados(){
        return apiMatheusClient.obterEstados();
    }

    public Collection<Municipio> obterMunicipios(@PathVariable Integer uf){
        return apiMatheusClient.obterMunicipios(uf);
    }
}
