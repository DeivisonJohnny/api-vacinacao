package com.dev_johnny.api_vacinacao.Controller;

import java.util.List;

import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dev_johnny.api_vacinacao.Entiny.postos.Postos;
import com.dev_johnny.api_vacinacao.Service.PostosService;
import com.dev_johnny.api_vacinacao.Utils.JwtUtils;

import io.github.cdimascio.dotenv.Dotenv;

@RestController
@RequestMapping("/postos")
public class PostosController {

    @Autowired
    private JwtUtils jwtUtils; // Injeção da dependência JwtUtils

    @Autowired
    PostosService postosService;

    private Dotenv dotenv = Dotenv.load();

    @GetMapping
    public Postos getListPostos() {
        return (Postos) postosService.getAll();
    }

    @PutMapping("/{id}")
    public RestResponse putPostosService(@PathVariable Integer id, @RequestBody Postos postos) {
        System.out.println(id);
        System.out.println(postos);

        postosService.putPostosService(id, postos);
        return new RestResponse(200, "Posto Atualizado");
    }

}
