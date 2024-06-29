package br.edu.infnet.matheusAPI.clients;

import br.edu.infnet.matheusAPI.model.domain.Estado;
import br.edu.infnet.matheusAPI.model.domain.Municipio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", name = "ibge")
public interface LocalidadeClient {
    @GetMapping(value = "/estados?orderBy=nome")
    Collection<Estado> obterEstados();

    @GetMapping(value = "/estados/{uf}/municipios")
    Collection<Municipio> obterMunicipios(@PathVariable Integer uf);
}
