package com.dev_johnny.api_vacinacao.Entiny.stationvaccine;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class StationVaccineId implements Serializable {

    private Integer postoId;  // Nome correto para o id do posto
    private Integer vacinaId; // Nome correto para o id da vacina

    public Integer getPostoId() {
        return postoId;
    }

    public void setPostoId(Integer postoId) {
        this.postoId = postoId; // Corrigido: use "this.postoId" em vez de "StationVaccineId.this.stationId"
    }

    public Integer getVacinaId() {
        return vacinaId;
    }

    public void setVacinaId(Integer vacinaId) {
        this.vacinaId = vacinaId; // Corrigido: use "this.vacinaId" em vez de "StationVaccineId.this.vaccineId"
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        StationVaccineId that = (StationVaccineId) o;

        if (!postoId.equals(that.postoId))
            return false;
        return vacinaId.equals(that.vacinaId);
    }

    @Override
    public int hashCode() {
        int result = postoId.hashCode();  // Corrigido: use "postoId" em vez de "stationId"
        result = 31 * result + vacinaId.hashCode();  // Corrigido: use "vacinaId" em vez de "vaccineId"
        return result;
    }
}
