package com.dev_johnny.api_vacinacao.Entiny.vacinas;

import com.dev_johnny.api_vacinacao.Entiny.postos.Postos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Vacinas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String description;
    private String tipo;


}
