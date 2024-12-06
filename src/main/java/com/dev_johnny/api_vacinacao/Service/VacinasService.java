package com.dev_johnny.api_vacinacao.Service;

import java.util.List;

import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import com.dev_johnny.api_vacinacao.DTO.VacinaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dev_johnny.api_vacinacao.Entiny.vacinas.Vacinas;
import com.dev_johnny.api_vacinacao.Repository.VacinasRepository;

@Service // Adicionando a anotação @Service aqui
public class VacinasService {

    @Autowired
    private VacinasRepository vacinasRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Vacinas> getAll() {
        return vacinasRepository.findAll();
    }

    public RestResponse createVaccines(@Valid VacinaDTO vacinas) {

        Vacinas vacina = new Vacinas();
        vacina.setName(vacinas.name());
        vacina.setDescription(vacinas.description());
        vacina.setTipo(vacinas.tipo());

        System.out.println(vacina);

        Vacinas savedVacina = vacinasRepository.save(vacina);

        if(savedVacina == null) {
            return new RestResponse(500, "Erro inesperado ao cadastrar vacina");
        }

        return new RestResponse(201, "Vacina criada com sucesso");

    }

}
