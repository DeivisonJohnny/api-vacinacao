package com.dev_johnny.api_vacinacao.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Postos> getListPostos() {
        return postosService.getAll();
    }

    @GetMapping("/b")
    public String getToken() {
        String token = jwtUtils.generateToken("deivisonjohnny");
        return token;
    }


}
