package br.edu.infnet.restaurante.matheus.model.service;

import br.edu.infnet.restaurante.matheus.clients.ApiMatheusClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ApiService {
    @Autowired
    private ApiMatheusClient apiMatheusClient;
    public Collection<String> obterLista() {
        return apiMatheusClient.obterLista();
    }
}
