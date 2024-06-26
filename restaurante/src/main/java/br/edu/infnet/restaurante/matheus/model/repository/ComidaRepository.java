package br.edu.infnet.restaurante.matheus.model.repository;

import br.edu.infnet.restaurante.matheus.model.domain.Comida;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ComidaRepository extends CrudRepository<Comida, Integer> {

    Collection<Comida> findByServeQtdPessoas(int serveQtdPessoas);

    Collection<Comida> findAll(Sort by);

}
