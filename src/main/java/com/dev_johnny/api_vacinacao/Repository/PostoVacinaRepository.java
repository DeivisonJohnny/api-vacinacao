package com.dev_johnny.api_vacinacao.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev_johnny.api_vacinacao.Entiny.postovacina.PostoVacina;
import com.dev_johnny.api_vacinacao.Entiny.postovacina.PostoVacinaId;

@Repository
public interface PostoVacinaRepository extends JpaRepository<PostoVacina, PostoVacinaId> {

    @Query(value = "SELECT * FROM postos_vacinas WHERE posto_id = :postoId", nativeQuery = true)
    List<PostoVacina> findByPostoId(@Param("postoId") Integer postoId);

    @Query("SELECT pv FROM PostoVacina pv")
    List<PostoVacina> findAllPostosVacinas();

}
