package com.dev_johnny.api_vacinacao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev_johnny.api_vacinacao.Entiny.stationvaccine.StationVaccine;
import com.dev_johnny.api_vacinacao.Entiny.station.Station;
import com.dev_johnny.api_vacinacao.Entiny.stationvaccine.StationVaccineId;

@Repository
public interface StationVaccineRepository extends JpaRepository<StationVaccine, StationVaccineId> {
    @Query("SELECT p FROM Station p LEFT JOIN FETCH p.vacinas v")
    List<Station> findAllStationsWithVaccines();
}
