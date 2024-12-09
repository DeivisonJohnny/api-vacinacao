package com.dev_johnny.api_vacinacao.Service;

import com.dev_johnny.api_vacinacao.DTO.StationDTO;
import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import com.dev_johnny.api_vacinacao.Entiny.station.Station;
import com.dev_johnny.api_vacinacao.Repository.StationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {
    @Autowired
    StationRepository stationRepository;

    public List<StationDTO> getAll() {
        List<Station> stations = stationRepository.findAll();
        return stations.stream()
                .map(stationResponse -> new StationDTO(
                        stationResponse.getId(),
                        stationResponse.getName(),
                        stationResponse.getEndereco(),
                        stationResponse.getLatitude(),
                        stationResponse.getLongitude()))
                .collect(Collectors.toList());
    }

    public RestResponse create(StationDTO stationsBody) {

        Station station = new Station();
        station.setName(stationsBody.name());
        station.setEndereco(stationsBody.endereco());
        station.setLatitude(stationsBody.latitude());
        station.setLongitude(stationsBody.longitude());

        System.out.println(station);

        stationRepository.save(station);

        return new RestResponse(201, "Post created successfully");
    }

    public RestResponse put(Integer id, Station station) {
        Station stationResponse = stationRepository.findById(id).orElseThrow(() -> new RuntimeException("Posto não encontrados"));

        stationResponse.setName(station.getName());
        stationResponse.setEndereco(station.getEndereco());
        stationResponse.setLatitude(station.getLatitude());
        stationResponse.setLongitude(station.getLongitude());

        stationRepository.save(stationResponse);

        return new RestResponse(201, "Post updated successfully");
    }

    public void delete(Integer id) {
        if (!stationRepository.existsById(id)) {
            throw new EntityNotFoundException("Post with ID " + id + " not found");
        }

        stationRepository.deleteById(id);

    }

}
