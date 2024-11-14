package com.dev_johnny.api_vacinacao.Controller;

import com.dev_johnny.api_vacinacao.Entiny.Vacinas;
import com.dev_johnny.api_vacinacao.Service.VacinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinasController {

    @Autowired
    private VacinasService vacinasService;

    @GetMapping
    public List<Vacinas> listarVacinas() {
        return vacinasService.getAll();
    }
}
