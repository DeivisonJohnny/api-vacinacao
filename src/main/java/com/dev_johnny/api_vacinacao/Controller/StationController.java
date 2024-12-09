package com.dev_johnny.api_vacinacao.Controller;

import java.util.List;

import com.dev_johnny.api_vacinacao.DTO.StationDTO;
import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev_johnny.api_vacinacao.Entiny.station.Station;
import com.dev_johnny.api_vacinacao.Service.StationService;

@RestController
@RequestMapping("/posto")
public class StationController {

    @Autowired
    StationService stationService;

    @GetMapping
    public List<StationDTO> getAllStations() {
        return stationService.getAll();
    }

    @PostMapping
    public RestResponse create(@Valid @RequestBody StationDTO station) {
        return stationService.create(station);
    }

    @PutMapping("/{id}")
    public RestResponse putStation(@PathVariable Integer id, @RequestBody Station station) {
        return stationService.put(id, station);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStation(@PathVariable Integer id) {
        stationService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
