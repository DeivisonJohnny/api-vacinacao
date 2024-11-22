package com.dev_johnny.api_vacinacao.Entiny.postovacina;

import java.io.Serializable;

import com.dev_johnny.api_vacinacao.Entiny.vacinas.Vacinas;
import com.dev_johnny.api_vacinacao.Entiny.postos.Postos;
import jakarta.persistence.Column;
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