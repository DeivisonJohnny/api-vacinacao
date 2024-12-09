package com.dev_johnny.api_vacinacao.Controller;

import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import com.dev_johnny.api_vacinacao.DTO.VaccinesDTO;
import com.dev_johnny.api_vacinacao.Entiny.vaccines.Vaccine;
import com.dev_johnny.api_vacinacao.Service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacina")
public class VaccinesController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping
    public List<Vaccine> getAllVaccines() {
        return vaccineService.getAll();
    }

    @PostMapping
    public RestResponse create(@RequestBody VaccinesDTO Vaccine) {
        return vaccineService.createVaccines(Vaccine);
    }

    @PutMapping("/{id}")
    public RestResponse put(@PathVariable Integer id, @RequestBody VaccinesDTO vaccine) {
        return vaccineService.updateVaccines(id, vaccine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        vaccineService.deleteVaccines(id);
        return ResponseEntity.noContent().build();
    }

}
