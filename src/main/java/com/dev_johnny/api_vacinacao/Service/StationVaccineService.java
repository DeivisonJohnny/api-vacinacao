package com.dev_johnny.api_vacinacao.Service;

import java.util.*;

import com.dev_johnny.api_vacinacao.Entiny.station.Station;
import com.dev_johnny.api_vacinacao.Entiny.vaccines.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev_johnny.api_vacinacao.Entiny.stationvaccine.StationVaccine;
import com.dev_johnny.api_vacinacao.Repository.StationVaccineRepository;

@Service
public class StationVaccineService {

    @Autowired
    private StationVaccineRepository stationVaccineRepository;

    public List<Map<String, Object>> getAll() {
        List<Station> stationsvaccines = stationVaccineRepository.findAllStationsWithVaccines();

        List<Map<String, Object>> resultado = new ArrayList<>();

        for (Station stationData : stationsvaccines) {
            Map<String, Object> stationMap = new LinkedHashMap<>();

            stationMap.put("id", stationData.getId());
            stationMap.put("name", stationData.getName());
            stationMap.put("endereco", stationData.getEndereco());
            stationMap.put("latitude", stationData.getLatitude());
            stationMap.put("longitude", stationData.getLongitude());

            List<Map<String, Object>> vacinasList = new ArrayList<>();

            if (stationData.getVacinas() != null && !stationData.getVacinas().isEmpty()) {
                for (StationVaccine stationVaccine : stationData.getVacinas()) {
                    Vaccine vacina = stationVaccine.getVacina();
                    Map<String, Object> vacinaMap = new LinkedHashMap<>();
                    vacinaMap.put("id", vacina.getId());
                    vacinaMap.put("name", vacina.getName());
                    vacinaMap.put("descricao", vacina.getDescription());
                    vacinaMap.put("tipo", vacina.getTipo());
                    vacinaMap.put("quantidade", stationVaccine.getAmount());

                    vacinasList.add(vacinaMap);
                }
            }

            stationMap.put("vacinas", vacinasList);

            resultado.add(stationMap);
        }
        return resultado;
    }
}
