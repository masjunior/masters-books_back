package com.example.masters_of_books.tiposResidencia;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipoResidencias")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Slf4j
public class TipoResidenciaController {

    @Autowired
    private TipoResidenciaService tipoResidenciaService;

    @GetMapping("")
    public ResponseEntity<List<TipoResidencia>> listar() {
        List<TipoResidencia> tipoResidencias = tipoResidenciaService.listar();
        log.info("URL /tipoResidencias requested");
        return ResponseEntity.ok(tipoResidencias);
    }

    @GetMapping("/novo")
    public String exibirFormularioNovo(Model model) {
        TipoResidencia tipoResidencia = new TipoResidencia();
        model.addAttribute("pais", tipoResidencia);
        return "formularioPais";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("pais") TipoResidencia tipoResidencia) {
        tipoResidenciaService.salvar(tipoResidencia);
        return "redirect:/paiss/";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEditar(@PathVariable Long id, Model model) {
        TipoResidencia tipoResidencia = tipoResidenciaService.buscarPorId(id);
        model.addAttribute("pais", tipoResidencia);
        return "formularioPais";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        tipoResidenciaService.excluir(id);
        return "redirect:/paises/";
    }
}





