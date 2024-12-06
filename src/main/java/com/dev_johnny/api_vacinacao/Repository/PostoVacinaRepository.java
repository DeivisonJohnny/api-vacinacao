package com.dev_johnny.api_vacinacao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev_johnny.api_vacinacao.Entiny.postovacina.PostoVacina;
import com.dev_johnny.api_vacinacao.Entiny.postos.Postos;
import com.dev_johnny.api_vacinacao.Entiny.postovacina.PostoVacinaId;

@Repository
public interface PostoVacinaRepository extends JpaRepository<PostoVacina, PostoVacinaId> {

    @Query("SELECT pv FROM PostoVacina pv WHERE pv.id.postoId = :postoId")
    List<PostoVacina> findByPostoId(@Param("postoId") Integer postoId);

    @Query("SELECT p FROM Postos p LEFT JOIN FETCH p.vacinas v")
    List<Postos> findAllPostosComVacinas();
}
