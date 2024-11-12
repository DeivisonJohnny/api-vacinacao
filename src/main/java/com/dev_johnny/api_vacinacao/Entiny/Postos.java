package com.dev_johnny.api_vacinacao.Entiny;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

}
