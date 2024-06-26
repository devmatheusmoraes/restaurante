package br.edu.infnet.restaurante.matheus.model.repository;

import br.edu.infnet.restaurante.matheus.model.domain.Bebida;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface BebidaRepository extends CrudRepository<Bebida, Integer> {

    Collection<Bebida> findByMarca(String marca);
    Collection<Bebida> findAll(Sort by);

}
