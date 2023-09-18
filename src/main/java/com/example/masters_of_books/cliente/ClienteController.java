package com.example.masters_of_books.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
//    public ModelAndView listarClientes() {
//        List<Cliente> clientes = clienteService.listarClientes();
//        ModelAndView modelAndView = new ModelAndView("listaClientes");
//        modelAndView.addObject("clientes", clientes);
//        return modelAndView;
//    }
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        Cliente cliente = new Cliente();
        cliente.setEmail("TESTE@123");
        cliente.setSenha("seila");
        cliente.setId(1L);
        System.out.println("URL /clientes requested");
        clientes.add(cliente);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/novo")
    public String exibirFormularioNovoCliente(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "formularioCliente";
    }

    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.salvarCliente(cliente);
        return "redirect:/clientes/";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEditarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        model.addAttribute("cliente", cliente);
        return "formularioCliente";
    }

    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        return "redirect:/clientes/";
    }
}





