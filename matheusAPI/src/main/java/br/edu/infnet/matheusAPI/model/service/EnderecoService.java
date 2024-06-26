package br.edu.infnet.matheusAPI.model.service;

import br.edu.infnet.matheusAPI.clients.EnderecoClient;
import br.edu.infnet.matheusAPI.model.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoClient enderecoClient;

    public Endereco obterPorCep(String cep) {
        return enderecoClient.obterPorCep(cep);
    }

}
