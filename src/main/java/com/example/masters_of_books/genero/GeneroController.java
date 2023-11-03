package com.example.masters_of_books.genero;

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
@RequestMapping("/generos")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class GeneroController {

    @Autowired
    private GeneroService service;

    @GetMapping("")
    public ResponseEntity<List<Genero>> listar() {
        log.info("URL /list requested");
        List<Genero> list = service.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/novo")
    public String exibirFormularioNovoCliente(Model model) {
        log.info("URL /list/novo requested");
        Genero entidade = new Genero();
        model.addAttribute("entidade", entidade);
        return "formularioCliente";
    }

    @GetMapping("/{id}")
    public ResponseEntity <Genero> consultaClientePorId(@PathVariable Long id) {
        log.info("URL /genero/{id} requested");
        Genero entidade = service.buscarPorId(id);
        if(entidade == null){
            log.info("URL /genero/{id} requested and not found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(entidade);
    }

    @GetMapping("/editar/{id}") // TODO: Mudar para post.
    public ResponseEntity <Genero> exibirFormularioEditarCliente(@PathVariable Long id) {
        log.info("URL /genero/editar/{id} requested");
        Genero entidade = service.buscarPorId(id);
        if(entidade == null){
            log.info("URL /genero/editar/{id} requested and not found");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
//        model.addAttribute("entidade", entidade);
        return ResponseEntity.ok(entidade);
    }

    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable Long id) {
        log.info("URL /list/excluir/{id} requested");
        service.excluir(id);
        return "redirect:/list/";
    }
}





