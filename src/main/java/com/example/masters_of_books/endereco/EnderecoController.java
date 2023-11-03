package com.example.masters_of_books.endereco;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/enderecos")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Slf4j
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("")
    public ResponseEntity<List<Endereco>> listar() {
        List<Endereco> list = service.listar();
        log.info("URL /Estados requested");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        Endereco entidade = new Endereco();
        model.addAttribute("Endereco", entidade);
        return "formularioEstado";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("Endereco") Endereco tipoResidencia) {
        service.salvar(tipoResidencia);
        return "redirect:/Estados/";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        Endereco entidade = service.buscarPorId(id);
        model.addAttribute("Endereco", entidade);
        return "formularioEstado";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/Estados/";
    }
}





