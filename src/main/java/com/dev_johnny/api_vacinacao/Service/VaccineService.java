package com.dev_johnny.api_vacinacao.Service;

import java.util.List;

import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import com.dev_johnny.api_vacinacao.DTO.VaccinesDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dev_johnny.api_vacinacao.Entiny.vaccines.Vaccine;
import com.dev_johnny.api_vacinacao.Repository.VaccineRepository;

@Service
public class VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Vaccine> getAll() {
        return vaccineRepository.findAll();
    }

    public RestResponse createVaccines(@Valid VaccinesDTO vaccineBody) {

        Vaccine vaccine = new Vaccine();
        vaccine.setName(vaccineBody.name());
        vaccine.setDescription(vaccineBody.description());
        vaccine.setTipo(vaccineBody.tipo());

        System.out.println(vaccine);

        vaccineRepository.save(vaccine);

        return new RestResponse(201, "Successfully created vaccine");

    }

    public RestResponse updateVaccines(Integer id, @Valid VaccinesDTO vaccineBody) {
        Vaccine vaccine = vaccineRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vaccine id: " +id+ " not found"));

        vaccine.setName(vaccineBody.name());
        vaccine.setDescription(vaccineBody.description());
        vaccine.setTipo(vaccineBody.tipo());

        vaccineRepository.save(vaccine);

        return new RestResponse(200, "Vaccine updated successfully");
    }

    public void deleteVaccines(Integer id) {
        vaccineRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vaccine id: " +id+ " not found"));
        vaccineRepository.deleteById(id);
    }

}
