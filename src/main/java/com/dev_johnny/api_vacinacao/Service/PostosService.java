package com.dev_johnny.api_vacinacao.Service;

import com.dev_johnny.api_vacinacao.DTO.PostosDTO;
import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import com.dev_johnny.api_vacinacao.Entiny.postos.Postos;
import com.dev_johnny.api_vacinacao.Repository.PostosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostosService {
    @Autowired
    PostosRepository postosRepository;

    public List<PostosDTO> getAll() {
        List<Postos> postos = postosRepository.findAll();
        return postos.stream()
                .map(posto -> new PostosDTO(
                        posto.getId(),
                        posto.getName(),
                        posto.getEndereco(),
                        posto.getLatitude(),
                        posto.getLongitude()))
                .collect(Collectors.toList());
    }

    public RestResponse create(PostosDTO postos) {

        Postos posto = new Postos();
        posto.setName(postos.name());
        posto.setEndereco(postos.endereco());
        posto.setLatitude(postos.latitude());
        posto.setLongitude(postos.longitude());

        Postos savedPosto = postosRepository.save(posto);

        if(savedPosto == null) {
            return new RestResponse(500, "Erro inesperado ao salvar o posto");
        }

        return new RestResponse(201, "Posto criado com sucesso!");
    }

    public RestResponse putPostosService(Integer id, Postos posto) {
        Postos postosEntiny = postosRepository.findById(id).orElseThrow(() -> new RuntimeException("Posto não encontrados"));

        postosEntiny.setName(posto.getName());
        postosEntiny.setEndereco(posto.getEndereco());
        postosEntiny.setLatitude(posto.getLatitude());
        postosEntiny.setLongitude(posto.getLongitude());

        if(!postosRepository.existsById(id)) {
            return new RestResponse(500, "Erro ao atualizar o posto");
        }

        return new RestResponse(201, "Posto Atualizado com Sucesso");
    }

    public RestResponse deletePostos(Integer id) {
        if (!postosRepository.existsById(id)) {
            throw new EntityNotFoundException("Posto com ID " + id + " não encontrado");
        }

        postosRepository.deleteById(id);
        return new RestResponse(204, "Posto excluído com sucesso");
    }

}
