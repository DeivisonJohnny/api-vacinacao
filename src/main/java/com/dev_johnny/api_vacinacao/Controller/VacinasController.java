package com.dev_johnny.api_vacinacao.Controller;

import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import com.dev_johnny.api_vacinacao.DTO.VacinaDTO;
import com.dev_johnny.api_vacinacao.Entiny.vacinas.Vacinas;
import com.dev_johnny.api_vacinacao.Service.VacinasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacina")
public class VacinasController {

    @Autowired
    private VacinasService vacinasService;

    @GetMapping
    public List<Vacinas> getAllVacinas() {
        return vacinasService.getAll();
    }

    @PostMapping
    public RestResponse create(@RequestBody VacinaDTO vacina) {
        return vacinasService.createVaccines(vacina);
    }

    @PutMapping("/{id}")
    public RestResponse update(@PathVariable Integer id, @RequestBody VacinaDTO vacina) {
        return vacinasService.updateVaccines(id, vacina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        vacinasService.deleteVaccines(id);
        return ResponseEntity.noContent().build();
    }

}
