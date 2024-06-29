package br.edu.infnet.restaurante.matheus.model.service;

import br.edu.infnet.restaurante.matheus.clients.ApiMatheusClient;
import br.edu.infnet.restaurante.matheus.model.domain.Endereco;
import br.edu.infnet.restaurante.matheus.model.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Collection<Endereco> obterLista() {
        return (Collection<Endereco>) enderecoRepository.findAll();
    }

    public long obterQtde() {
        return enderecoRepository.count();
    }

}
