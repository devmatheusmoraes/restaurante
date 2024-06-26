package br.edu.infnet.restaurante.matheus.model.service;

import br.edu.infnet.restaurante.matheus.model.domain.Bebida;
import br.edu.infnet.restaurante.matheus.model.domain.Comida;
import br.edu.infnet.restaurante.matheus.model.domain.Pedido;
import br.edu.infnet.restaurante.matheus.model.repository.BebidaRepository;
import br.edu.infnet.restaurante.matheus.model.repository.ComidaRepository;
import br.edu.infnet.restaurante.matheus.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private BebidaRepository bebidaRepository;
    @Autowired
    private ComidaRepository comidaRepository;

    public void incluir(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    public Collection<Pedido> obterLista(){
        return (Collection<Pedido>) pedidoRepository.findAll();
    }

    public Pedido obterPorId(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public void excluir(Integer id) {
        pedidoRepository.deleteById(id);
    }

    public long obterQtde() {
        return pedidoRepository.count();
    }

    public void alterar(Integer id, Pedido pedidoAtualizado){
        pedidoAtualizado.setId(id);
        pedidoRepository.save(pedidoAtualizado);
    }

    public void incluirComida(Integer id, Comida comida){
        Pedido pedido = obterPorId(id);
        pedido.getProdutos().add(comida);
        pedido.setTotal(pedido.getTotal() + comida.getPreco());
        alterar(pedido.getId(), pedido);
    }

    public void incluirBebida(Integer id, Bebida bebida){
        Pedido pedido = obterPorId(id);
        pedido.getProdutos().add(bebida);
        pedido.setTotal(pedido.getTotal() + bebida.getPreco());
        alterar(pedido.getId(),pedido);
    }

    public Pedido findByCodigo(int codigo){
        return pedidoRepository.findByCodigo(codigo);
    }

    public Collection<Pedido> obterLista(String orderBy){
        return pedidoRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
    }
}
