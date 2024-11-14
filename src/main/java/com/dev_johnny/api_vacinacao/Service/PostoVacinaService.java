package com.dev_johnny.api_vacinacao.Service;

import com.dev_johnny.api_vacinacao.Entiny.PostoVacina;
import com.dev_johnny.api_vacinacao.Repository.PostoVacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostoVacinaService {

    @Autowired
    private PostoVacinaRepository postoVacinaRepository;

    public List<PostoVacina> getVacinasByPosto(Integer postoId) {
        return  postoVacinaRepository.findByPostoId(postoId);
    }

    public List<PostoVacina> getAll() {

            return postoVacinaRepository.findAllPostosVacinas();

    }

}
