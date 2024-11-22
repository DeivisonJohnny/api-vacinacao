package com.dev_johnny.api_vacinacao.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev_johnny.api_vacinacao.Entiny.postovacina.PostoVacina;
import com.dev_johnny.api_vacinacao.Repository.PostoVacinaRepository;

@Service
public class PostoVacinaService {

    @Autowired
    private PostoVacinaRepository postoVacinaRepository;

    public List<PostoVacina> getVacinasByPosto(Integer postoId) {
        return postoVacinaRepository.findByPostoId(postoId);
    }

    public List<PostoVacina> getAll() {

        return postoVacinaRepository.findAllPostosVacinas();

    }

}
