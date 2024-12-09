package com.dev_johnny.api_vacinacao.Entiny.vaccines;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "vacinas")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String description;
    private String tipo;


}
