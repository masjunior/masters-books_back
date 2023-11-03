package com.example.masters_of_books.cidade;

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
@RequestMapping("/cidades")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Slf4j
public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping("")
    public ResponseEntity<List<Cidade>> listar() {
        List<Cidade> list = service.listar();
        log.info("URL /Estados requested");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        Cidade entidade = new Cidade();
        model.addAttribute("Cidade", entidade);
        return "formularioEstado";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("Cidade") Cidade tipoResidencia) {
        service.salvar(tipoResidencia);
        return "redirect:/Estados/";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        Cidade entidade = service.buscarPorId(id);
        model.addAttribute("Cidade", entidade);
        return "formularioEstado";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/Estados/";
    }
}





