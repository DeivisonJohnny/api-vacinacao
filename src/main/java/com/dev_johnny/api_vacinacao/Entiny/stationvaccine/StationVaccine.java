package com.dev_johnny.api_vacinacao.Entiny.stationvaccine;

import java.io.Serializable;

import com.dev_johnny.api_vacinacao.Entiny.vaccines.Vaccine;
import com.dev_johnny.api_vacinacao.Entiny.station.Station;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "postos_vacinas")
public class StationVaccine implements Serializable {

    @EmbeddedId
    private StationVaccineId id;

    @ManyToOne
    @MapsId("postoId")
    @JoinColumn(name = "posto_id")
    @JsonIgnore
    private Station posto;

    @ManyToOne
    @MapsId("vacinaId")
    @JoinColumn(name = "vacina_id")
    private Vaccine vacina;

    private Integer amount;

}
