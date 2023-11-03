package com.example.masters_of_books.cliente;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<List<Cliente>> listarClientes() {
        log.info("URL /clientes requested");
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/novo")
    public String exibirFormularioNovoCliente(Model model) {
        log.info("URL /clientes/novo requested");
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "formularioCliente";
    }

    @GetMapping("/{id}")
    public ResponseEntity <Cliente> consultaClientePorId(@PathVariable Long id) {
        log.info("URL /clientes/{id} requested");
        Cliente cliente = clienteService.buscarClientePorId(id);
        if(cliente == null){
            log.info("URL /clientes/{id} requested and not found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/editar/{id}") // TODO: Mudar para post.
    public ResponseEntity <Cliente> exibirFormularioEditarCliente(@PathVariable Long id) {
        log.info("URL /clientes/editar/{id} requested");
        Cliente cliente = clienteService.buscarClientePorId(id);
        if(cliente == null){
            log.info("URL /clientes/editar/{id} requested and not found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
//        model.addAttribute("cliente", cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable Long id) {
        log.info("URL /clientes/excluir/{id} requested");
        clienteService.excluirCliente(id);
        return "redirect:/clientes/";
    }
}





