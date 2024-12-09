package com.dev_johnny.api_vacinacao.Service;

import java.util.*;

import com.dev_johnny.api_vacinacao.Entiny.station.Station;
import com.dev_johnny.api_vacinacao.Entiny.vaccines.Vaccine;
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

    public List<Map<String, Object>> getAll() {
        List<Station> postos = postoVacinaRepository.findAllPostosComVacinas();

        List<Map<String, Object>> resultado = new ArrayList<>();

        for (Station posto : postos) {
            Map<String, Object> postoMap = new LinkedHashMap<>();

            postoMap.put("id", posto.getId());
            postoMap.put("name", posto.getName());
            postoMap.put("endereco", posto.getEndereco());
            postoMap.put("latitude", posto.getLatitude());
            postoMap.put("longitude", posto.getLongitude());

            List<Map<String, Object>> vacinasList = new ArrayList<>();

            if (posto.getVacinas() != null && !posto.getVacinas().isEmpty()) {
                for (PostoVacina postoVacina : posto.getVacinas()) {
                    Vaccine vacina = postoVacina.getVacina();
                    Map<String, Object> vacinaMap = new LinkedHashMap<>();
                    vacinaMap.put("id", vacina.getId());
                    vacinaMap.put("name", vacina.getName());
                    vacinaMap.put("descricao", vacina.getDescription());
                    vacinaMap.put("tipo", vacina.getTipo());
                    vacinaMap.put("quantidade", postoVacina.getAmount());

                    vacinasList.add(vacinaMap);
                }
            }

            postoMap.put("vacinas", vacinasList);

            resultado.add(postoMap);
        }
        return resultado;
    }
}
