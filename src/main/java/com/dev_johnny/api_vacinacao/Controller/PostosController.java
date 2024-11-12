package com.dev_johnny.api_vacinacao.Controller;

import com.dev_johnny.api_vacinacao.Entiny.Postos;
import com.dev_johnny.api_vacinacao.Service.PostosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postos")

public class PostosController {
    @Autowired
    PostosService postosService;

    @GetMapping
    public List<Postos> getListPostos() {

        return postosService.getAll();

    }

}
