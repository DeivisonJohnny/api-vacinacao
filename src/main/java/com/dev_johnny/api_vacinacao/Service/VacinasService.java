package com.dev_johnny.api_vacinacao.Service;

import java.util.List;

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

    public List<String> getTables() {
        String sql = "SHOW TABLES";
        return jdbcTemplate.queryForList(sql, String.class);
    }

}
