package br.edu.infnet.restaurante.matheus.clients;

import br.edu.infnet.restaurante.matheus.model.domain.Estado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(url = "https://servicodados.ibge.gov.br/api/v1/localidades", value = "ibge")
public interface LocalidadeClient {

        @GetMapping(value = "/estados?orderBy=nome")
        Collection<Estado> obterEstados();

}
