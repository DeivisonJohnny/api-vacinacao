package com.dev_johnny.api_vacinacao.Service;

import com.dev_johnny.api_vacinacao.Entiny.Postos;
import com.dev_johnny.api_vacinacao.Repository.PostosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostosService {
    @Autowired
    PostosRepository postosRepository;

    public List<Postos> getAll() {

        return postosRepository.findAll();

    }
}
