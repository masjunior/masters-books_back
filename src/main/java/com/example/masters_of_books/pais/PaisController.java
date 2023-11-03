package com.example.masters_of_books.pais;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paises")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Slf4j
public class PaisController {

    @Autowired
    private PaisService service;

    @GetMapping("")
    public ResponseEntity<List<Pais>> listar() {
        List<Pais> paises = service.listar();
        log.info("URL /paises requested");
        return ResponseEntity.ok(paises);
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        Pais tipoResidencia = new Pais();
        model.addAttribute("pais", tipoResidencia);
        return "formularioPais";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("pais") Pais tipoResidencia) {
        service.salvar(tipoResidencia);
        return "redirect:/paiss/";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        Pais tipoResidencia = service.buscarPorId(id);
        model.addAttribute("pais", tipoResidencia);
        return "formularioPais";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.excluir(id);
        return "redirect:/paises/";
    }
}





