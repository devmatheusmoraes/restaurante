package br.edu.infnet.restaurante.matheus.controllers;

import br.edu.infnet.restaurante.matheus.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ComidaService comidaService;
    @Autowired
    private BebidaService bebidaService;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/")
    public String telaHome(Model model) {

        model.addAttribute("qtdePedido", pedidoService.obterQtde());
        model.addAttribute("qtdeComida", comidaService.obterQtde());
        model.addAttribute("qtdeBebida", bebidaService.obterQtde());
        model.addAttribute("qtdeEndereco", enderecoService.obterQtde());
        model.addAttribute("estados", apiService.obterEstados());

        return "home";
    }

    @GetMapping(value = "/pedido/listagem")
    public String listaPedidos(Model model) {

        model.addAttribute("titulo", "Listagem de Pedidos");
        model.addAttribute("listagem", pedidoService.obterLista());

        return telaHome(model);
    }

    @GetMapping(value = "/comida/listagem")
    public String listaComidas(Model model) {

        model.addAttribute("titulo", "Listagem de Comidas");
        model.addAttribute("listagem", comidaService.obterLista());

        return telaHome(model);
    }

    @GetMapping(value = "/bebida/listagem")
    public String listaBebidas(Model model) {

        model.addAttribute("titulo", "Listagem de Produtos Bebidas");
        model.addAttribute("listagem", bebidaService.obterLista());

        return telaHome(model);
    }

    @GetMapping(value = "/endereco/listagem")
    public String listaEnderecos(Model model){

        model.addAttribute("titulo", "Listagem de Endereços");
        model.addAttribute("listagem", enderecoService.obterLista());

        return telaHome(model);
    }

    @GetMapping(value = "/estado/listagem")
    public String listaEstados(Model model){

        model.addAttribute("titulo", "Listagem de Estados");
        model.addAttribute("listagem", apiService.obterEstados());

        return telaHome(model);
    }

    @GetMapping(value = "/municipio/listagem")
    public String listaMunicipios(Model model, @RequestParam Integer uf){

        model.addAttribute("titulo", "Listagem de Municipios");
        model.addAttribute("listagem", apiService.obterMunicipios(uf));

        return telaHome(model);
    }

}
