package com.dev_johnny.api_vacinacao.Service;

import com.dev_johnny.api_vacinacao.Entiny.postos.Postos;
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

    public Postos putPostosService(Integer id, Postos posto) {
        Postos postosEntiny = postosRepository.findById(id).orElseThrow(() -> new RuntimeException("Posto não encontrados"));

        postosEntiny.setName(posto.getName());
        postosEntiny.setEndereco(posto.getEndereco());
        postosEntiny.setLatitude(posto.getLatitude());
        postosEntiny.setLongitude(posto.getLongitude());


        return postosRepository.save(postosEntiny);
    }

}
