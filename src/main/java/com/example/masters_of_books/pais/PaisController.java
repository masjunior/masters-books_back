package com.example.masters_of_books.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paises")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("")
    public ResponseEntity<List<Pais>> listar() {
        List<Pais> paises = paisService.listar();
        System.out.println("URL /paises requested");
        return ResponseEntity.ok(paises);
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        Pais pais = new Pais();
        model.addAttribute("pais", pais);
        return "formularioPais";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("pais") Pais pais) {
        paisService.salvar(pais);
        return "redirect:/paiss/";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        Pais pais = paisService.buscarPorId(id);
        model.addAttribute("pais", pais);
        return "formularioPais";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        paisService.excluir(id);
        return "redirect:/paises/";
    }
}





