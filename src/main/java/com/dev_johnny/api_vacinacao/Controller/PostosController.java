package com.dev_johnny.api_vacinacao.Controller;

import java.util.List;

import com.dev_johnny.api_vacinacao.DTO.PostosDTO;
import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev_johnny.api_vacinacao.Entiny.postos.Postos;
import com.dev_johnny.api_vacinacao.Service.PostosService;
import com.dev_johnny.api_vacinacao.Utils.JwtUtils;

import io.github.cdimascio.dotenv.Dotenv;

@RestController
@RequestMapping("/posto")
public class PostosController {

    @Autowired
    PostosService postosService;

    @GetMapping
    public List<PostosDTO> getAllPostos() {
        return postosService.getAll();
    }

    @PostMapping
    public RestResponse create(@Valid @RequestBody PostosDTO posto) {
        return postosService.create(posto);
    }

    @PutMapping("/{id}")
    public RestResponse putPosto(@PathVariable Integer id, @RequestBody Postos postos) {
        return postosService.updatePosto(id, postos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosto(@PathVariable Integer id) {
        postosService.deletePosto(id);

        return ResponseEntity.noContent().build();
    }

}
