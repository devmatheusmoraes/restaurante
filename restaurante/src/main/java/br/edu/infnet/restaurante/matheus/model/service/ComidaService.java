package br.edu.infnet.restaurante.matheus.model.service;

import br.edu.infnet.restaurante.matheus.model.domain.Comida;
import br.edu.infnet.restaurante.matheus.model.repository.ComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ComidaService {

    @Autowired
    private ComidaRepository comidaRepository;

    public void incluir(Comida comida){
        comidaRepository.save(comida);
    }

    public Collection<Comida> obterLista(){
        return (Collection<Comida>) comidaRepository.findAll();
    }

    public Comida obterPorId(Integer id) {
        return comidaRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        comidaRepository.deleteById(id);
    }

    public long obterQtde() {
        return comidaRepository.count();
    }

    public void alterar(Integer id, Comida comidaAtualizada){
        comidaAtualizada.setId(id);
        comidaRepository.save(comidaAtualizada);
    }

    public Collection<Comida> findByServeQtdPessoas(int serveQtdPessoas){
        return comidaRepository.findByServeQtdPessoas(serveQtdPessoas);
    }

    public Collection<Comida> obterLista(String orderBy){
        return comidaRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
    }

}
