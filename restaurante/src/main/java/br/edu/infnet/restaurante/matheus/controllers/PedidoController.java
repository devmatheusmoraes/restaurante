package br.edu.infnet.restaurante.matheus.controllers;

import br.edu.infnet.restaurante.matheus.dto.PedidoDTO;
import br.edu.infnet.restaurante.matheus.model.domain.Bebida;
import br.edu.infnet.restaurante.matheus.model.domain.Comida;
import br.edu.infnet.restaurante.matheus.model.domain.Pedido;
import br.edu.infnet.restaurante.matheus.model.service.BebidaService;
import br.edu.infnet.restaurante.matheus.model.service.ComidaService;
import br.edu.infnet.restaurante.matheus.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ComidaService comidaService;

    @Autowired
    private BebidaService bebidaService;

    @GetMapping("/listar-todos")
    public ResponseEntity<Collection<Pedido>> listarTodos(@RequestParam String orderBy){
        return ResponseEntity.ok().body(pedidoService.obterLista(orderBy));
    }

    @GetMapping("/obterPorId/{id}")
    public ResponseEntity<Pedido> obterPorId(@PathVariable Integer id){
        return ResponseEntity.ok().body(pedidoService.obterPorId(id));
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody PedidoDTO dto){
        Pedido pedido1 = new Pedido(dto);
        pedidoService.incluir(pedido1);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido adicionado com sucesso");
    }

    @PutMapping("/adicionarComida/{idPedido}")
    public ResponseEntity<String> adicionarComida(@PathVariable Integer idPedido, @RequestBody Map<String, Integer> food){
        Integer idComida = food.get("idComida");

        if (idComida == null || idComida == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("comida inválida");
        }
        Comida comida = comidaService.obterPorId(idComida);
        pedidoService.incluirComida(idPedido, comida);
        return ResponseEntity.ok().body("Comida adicionada com sucesso.");
    }

    @PutMapping("/adicionarBebida/{idPedido}")
    public ResponseEntity<String> adicionarBebida(@PathVariable Integer idPedido, @RequestBody Map<String, Integer> drink){
        Integer idBebida = drink.get("idBebida");

        if (idBebida == null || idBebida == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("comida inválida");
        }
        Bebida bebida = bebidaService.obterPorId(idBebida);
        pedidoService.incluirBebida(idPedido, bebida);
        return ResponseEntity.ok().body("Bebida adicionada com sucesso.");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterar(@PathVariable Integer id, @RequestBody PedidoDTO dto){
        Pedido pedido1 = new Pedido(dto);
        pedidoService.alterar(id, pedido1);
        return ResponseEntity.ok().body("Pedido alterado com sucesso.");
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        pedidoService.excluir(id);
        return ResponseEntity.ok().body("Pedido excluído com sucesso.");
    }

    @GetMapping(value = "/listar-por-codigo/{codigo}")
    public ResponseEntity<Pedido> obterPorCodigo(@PathVariable int codigo){
        return ResponseEntity.ok().body(pedidoService.findByCodigo(codigo));
    }


}
