package br.edu.infnet.restaurante.matheus.controllers;

import br.edu.infnet.restaurante.matheus.model.domain.Bebida;
import br.edu.infnet.restaurante.matheus.model.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("bebida")
public class BebidaController {

    @Autowired
    private BebidaService bebidaService;

    @GetMapping("/listar-todas")
    public ResponseEntity<Collection<Bebida>> listarTodas(@RequestParam String orderBy){
        return ResponseEntity.ok().body(bebidaService.obterLista(orderBy));
    }

    @GetMapping("/obterPorId/{id}")
    public ResponseEntity<Bebida> obterPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(bebidaService.obterPorId(id));
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody Bebida bebida){
        Bebida bebida1 = new Bebida(
                bebida.getCodigo(),
                bebida.getDescricao(),
                bebida.getPreco(),
                bebida.isEstoque(),
                bebida.getMarca(),
                bebida.getTamanho()
        );
        bebidaService.incluir(bebida1);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bebida adicionada com sucesso");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody Bebida bebidaAtualizada){
        Bebida bebida1 = new Bebida(
                bebidaAtualizada.getCodigo(),
                bebidaAtualizada.getDescricao(),
                bebidaAtualizada.getPreco(),
                bebidaAtualizada.isEstoque(),
                bebidaAtualizada.getMarca(),
                bebidaAtualizada.getTamanho()
        );
        bebidaService.alterar(id, bebida1);
        return ResponseEntity.ok().body("Bebida alterada com sucesso.");
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        bebidaService.excluir(id);
        return ResponseEntity.ok().body("Bebida excluída com sucesso.");
    }

    @GetMapping(value = "/listar-todas-por-marca/{marca}")
    public ResponseEntity<Collection<Bebida>> obterListaMarca(@PathVariable String marca){
        return ResponseEntity.ok().body(bebidaService.findByMarca(marca));
    }

}
