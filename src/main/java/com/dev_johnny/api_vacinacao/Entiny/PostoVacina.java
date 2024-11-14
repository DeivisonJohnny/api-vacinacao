package com.dev_johnny.api_vacinacao.Entiny;

import com.dev_johnny.api_vacinacao.Entiny.Postos;
import com.dev_johnny.api_vacinacao.Entiny.Vacinas;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "postos_vacinas")
public class PostoVacina implements Serializable {

    @EmbeddedId
    private PostoVacinaId id;
    @ManyToOne
    @MapsId("postoId")
    @JoinColumn(name = "posto_id", referencedColumnName = "id")
    private Postos posto;

    @ManyToOne
    @MapsId("vacinaId")
    @JoinColumn(name = "vacina_id", referencedColumnName = "id")
    private Vacinas vacina;

    @Column(name = "amount")
    private Integer amount;

}
