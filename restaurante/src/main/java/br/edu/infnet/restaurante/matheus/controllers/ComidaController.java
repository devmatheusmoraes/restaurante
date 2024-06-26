package br.edu.infnet.restaurante.matheus.controllers;

import br.edu.infnet.restaurante.matheus.model.domain.Comida;
import br.edu.infnet.restaurante.matheus.model.service.ComidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("comida")
public class ComidaController {

    @Autowired
    private ComidaService comidaService;

    @GetMapping("/listar-todas")
    public ResponseEntity<Collection<Comida>> listarTodas(@RequestParam String orderBy){
        return ResponseEntity.ok().body(comidaService.obterLista(orderBy));
    }

    @GetMapping("/obterPorId/{id}")
    public ResponseEntity<Comida> obterPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(comidaService.obterPorId(id));
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody Comida comida){
        Comida comida1 = new Comida(
                comida.getCodigo(),
                comida.getDescricao(),
                comida.getPreco(),
                comida.isEstoque(),
                comida.getAcompanhamento(),
                comida.getServeQtdPessoas()
        );
        comidaService.incluir(comida1);
        return ResponseEntity.status(HttpStatus.CREATED).body("Comida adicionada com sucesso");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody Comida comidaAtualizada){
        Comida comida1 = new Comida(
                comidaAtualizada.getCodigo(),
                comidaAtualizada.getDescricao(),
                comidaAtualizada.getPreco(),
                comidaAtualizada.isEstoque(),
                comidaAtualizada.getAcompanhamento(),
                comidaAtualizada.getServeQtdPessoas()
        );
        comidaService.alterar(id, comida1);
        return ResponseEntity.ok().body("Comida alterada com sucesso.");
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        comidaService.excluir(id);
        return ResponseEntity.ok().body("Comida excluída com sucesso.");
    }

    @GetMapping(value = "/listar-todas-por-qtd-pessoas/{serveQtdPessoas}")
    public ResponseEntity<Collection<Comida>> obterListaServeQtdPessoas(@PathVariable int serveQtdPessoas){
        return ResponseEntity.ok().body(comidaService.findByServeQtdPessoas(serveQtdPessoas));
    }

}
