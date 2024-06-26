package br.edu.infnet.restaurante.matheus.model.service;

import br.edu.infnet.restaurante.matheus.model.domain.Bebida;
import br.edu.infnet.restaurante.matheus.model.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BebidaService {

    @Autowired
    private BebidaRepository bebidaRepository;

    public void incluir(Bebida bebida){
        bebidaRepository.save(bebida);
    }

    public Collection<Bebida> obterLista(){
        return (Collection<Bebida>) bebidaRepository.findAll();
    }

    public Bebida obterPorId(Integer id) {
        return bebidaRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        bebidaRepository.deleteById(id);
    }

    public long obterQtde() {
        return bebidaRepository.count();
    }

    public void alterar(Integer id, Bebida bebidaAtualizada){
        bebidaAtualizada.setId(id);
        bebidaRepository.save(bebidaAtualizada);
    }

    public Collection<Bebida> findByMarca(String marca){
        return bebidaRepository.findByMarca(marca);
    }

    public Collection<Bebida> obterLista(String orderBy){
        return bebidaRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
    }
}
