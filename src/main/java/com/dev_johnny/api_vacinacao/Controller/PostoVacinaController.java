package com.dev_johnny.api_vacinacao.Controller;

import com.dev_johnny.api_vacinacao.Entiny.postovacina.PostoVacina;
import com.dev_johnny.api_vacinacao.Service.PostoVacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/postos-vacinas")
public class PostoVacinaController {

    @Autowired
    private PostoVacinaService postoVacinaService;

    @GetMapping
    public List<Map<String, Object>> getListAll() {
        return postoVacinaService.getAll();
    }

    @GetMapping("/posto/{postoId}")
    public List<PostoVacina> getVacinasByPosto(@PathVariable Integer postoId) {
        return postoVacinaService.getVacinasByPosto(postoId);
    }

}
