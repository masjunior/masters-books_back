package com.example.masters_of_books.utils.controller;

import com.example.masters_of_books.utils.dominio.Dominio;
import com.example.masters_of_books.utils.service.DominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public abstract class DominioController {

    @Autowired
    private DominioService dominioService;

    @GetMapping("")

    public ResponseEntity<List<Dominio>> listar() {
        List<Dominio> dominios = dominioService.listar();
        System.out.println("URL / requested");
        return ResponseEntity.ok(dominios);
    }

    @GetMapping("/novo")
    public String exibirFormularioNovoDominio(Model model) {
        return "formularioDominio";
    }

    @PostMapping("/salvar")
    public String salvarDominio(@ModelAttribute("dominio") Dominio dominio) {
        dominioService.salvar(dominio);
        return "redirect:/dominios/";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEditarDominio(@PathVariable Long id, Model model) {
        Dominio dominio = dominioService.buscarPorId(id);
        model.addAttribute("dominio", dominio);
        return "formularioDominio";
    }

    @GetMapping("/excluir/{id}")
    public String excluirDominio(@PathVariable Long id) {
        dominioService.excluir(id);
        return "redirect:/dominios/";
    }
}





