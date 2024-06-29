package br.edu.infnet.restaurante.matheus.clients;

import br.edu.infnet.restaurante.matheus.model.domain.Celular;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://api.api-ninjas.com/v1/validatephone", value = "apiValidacaoCelular")
public interface ApiValidacaoCelularClient {

    @GetMapping
    public Celular obterCelularPorNumero(@RequestParam("number") String numero, @RequestHeader("X-Api-Key") String apiKey);
}
