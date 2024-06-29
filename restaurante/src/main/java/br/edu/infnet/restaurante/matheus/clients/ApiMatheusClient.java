package br.edu.infnet.restaurante.matheus.clients;

import br.edu.infnet.restaurante.matheus.model.domain.Endereco;
import br.edu.infnet.restaurante.matheus.model.domain.Estado;
import br.edu.infnet.restaurante.matheus.model.domain.Municipio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "http://localhost:8081", value = "apiMatheus")
public interface ApiMatheusClient {

    @GetMapping(value = "/{cep}")
    public Endereco obterEnderecoPorCep(@PathVariable String cep);

    @GetMapping(value = "/estados")
    public Collection<Estado> obterEstados();

    @GetMapping(value = "/{uf}/municipios")
    public Collection<Municipio> obterMunicipios(@PathVariable Integer uf);
}
