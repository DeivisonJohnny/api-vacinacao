package com.dev_johnny.api_vacinacao.Service;

import java.util.List;

import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import com.dev_johnny.api_vacinacao.DTO.VacinaDTO;
import jakarta.persistence.EntityNotFoundException;
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

        vacinasRepository.save(vacina);

        return new RestResponse(201, "Vacina criada com sucesso");

    }

    public RestResponse updateVaccines(Integer id, @Valid VacinaDTO vacina) {
        Vacinas vacinas = vacinasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vacina de id: " +id+ " não encontrada" ));

        vacinas.setName(vacina.name());
        vacinas.setDescription(vacina.description());
        vacinas.setTipo(vacina.tipo());

        vacinasRepository.save(vacinas);

        return new RestResponse(200, "Vacina atualizada com sucesso");
    }

    public void deleteVaccines(Integer id) {
        Vacinas vacinas = vacinasRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vacina de id: " +id+ " não encontrada" ));
        vacinasRepository.deleteById(id);
    }

}
