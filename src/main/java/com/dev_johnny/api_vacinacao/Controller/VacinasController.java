package com.dev_johnny.api_vacinacao.Controller;

import com.dev_johnny.api_vacinacao.Entiny.Vacinas;
import com.dev_johnny.api_vacinacao.Service.VacinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacinas")  // Define a rota base
public class VacinasController {

    @Autowired
    private VacinasService vacinasService;

    @GetMapping // Define a rota específica para listar
    public List<Vacinas> listarVacinas() {
        return vacinasService.getAll();
    }
}
