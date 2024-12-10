package com.dev_johnny.api_vacinacao.Controller;

import com.dev_johnny.api_vacinacao.Service.StationVaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/postos-vacinas")
public class StationVaccineController {

    @Autowired
    private StationVaccineService stationVaccineService;

    @GetMapping
    public List<Map<String, Object>> getAllStationWithVaccines() {
        return stationVaccineService.getAll();
    }
}
