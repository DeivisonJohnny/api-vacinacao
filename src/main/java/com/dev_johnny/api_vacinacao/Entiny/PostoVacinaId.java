package com.dev_johnny.api_vacinacao.Entiny;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PostoVacinaId implements Serializable {

    private Integer postoId;
    private Integer vacinaId;

    // Getters, Setters, hashCode, e equals

    public Integer getPostoId() {
        return postoId;
    }

    public void setPostoId(Integer postoId) {
        this.postoId = postoId;
    }

    public Integer getVacinaId() {
        return vacinaId;
    }

    public void setVacinaId(Integer vacinaId) {
        this.vacinaId = vacinaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostoVacinaId that = (PostoVacinaId) o;

        if (!postoId.equals(that.postoId)) return false;
        return vacinaId.equals(that.vacinaId);
    }

    @Override
    public int hashCode() {
        int result = postoId.hashCode();
        result = 31 * result + vacinaId.hashCode();
        return result;
    }
}
