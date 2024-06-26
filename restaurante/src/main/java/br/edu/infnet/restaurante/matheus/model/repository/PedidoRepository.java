package br.edu.infnet.restaurante.matheus.model.repository;

import br.edu.infnet.restaurante.matheus.model.domain.Pedido;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

    Pedido findByCodigo(int codigo);

    Collection<Pedido> findAll(Sort by);
}
