package com.dev_johnny.api_vacinacao.Entiny.postos;

import com.dev_johnny.api_vacinacao.Entiny.postovacina.PostoVacina;
import com.dev_johnny.api_vacinacao.Entiny.vacinas.Vacinas;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Postos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String endereco;
    private String latitude;
    private String longitude;


    @OneToMany(mappedBy = "posto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostoVacina> vacinas;

}
