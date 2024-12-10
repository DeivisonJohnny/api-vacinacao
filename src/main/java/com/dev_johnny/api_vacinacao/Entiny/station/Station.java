package com.dev_johnny.api_vacinacao.Entiny.station;

import com.dev_johnny.api_vacinacao.Entiny.stationvaccine.StationVaccine;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

@Table(name = "postos")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String endereco;
    private String latitude;
    private String longitude;

    @OneToMany(mappedBy = "posto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StationVaccine> vacinas;

}
