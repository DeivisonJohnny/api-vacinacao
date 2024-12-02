package com.dev_johnny.api_vacinacao.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.dev_johnny.api_vacinacao.Entiny.postos.Postos;
import com.dev_johnny.api_vacinacao.Entiny.vacinas.Vacinas;
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
        List<PostoVacina> postosVacinas = postoVacinaRepository.findAllPostosVacinas();

        Map<Integer, Map<String, Object>> resultado = new LinkedHashMap<>();

        for (PostoVacina pv : postosVacinas) {
            Postos posto = pv.getPosto();
            Vacinas vacina = pv.getVacina();

            // Inicializa o mapa do posto, se ainda não existir
            resultado.putIfAbsent(posto.getId(), new LinkedHashMap<>());
            Map<String, Object> postoMap = resultado.get(posto.getId());

            // Adiciona informações do posto (ordem mantida)
            postoMap.putIfAbsent("id", posto.getId());
            postoMap.putIfAbsent("nome", posto.getName());
            postoMap.putIfAbsent("endereco", posto.getEndereco());
            postoMap.putIfAbsent("latitude", posto.getLatitude());
            postoMap.putIfAbsent("longitude", posto.getLongitude());
            postoMap.putIfAbsent("vacinas", new LinkedHashMap<>());

            // Adiciona informações da vacina no submapa
            Map<String, Object> vacinasMap = (Map<String, Object>) postoMap.get("vacinas");
            vacinasMap.put("vacina" + vacina.getId(), Map.of(
                    "id", vacina.getId(),
                    "nome", vacina.getName(),
                    "descricao", vacina.getDescription(),
                    "tipo", vacina.getTipo(),
                    "quantidade", pv.getAmount()
            ));
        }

        // Converte o resultado em lista
        return new ArrayList<>(resultado.values());
    }

}
