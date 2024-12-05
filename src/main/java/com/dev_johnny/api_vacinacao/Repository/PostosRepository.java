package com.dev_johnny.api_vacinacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dev_johnny.api_vacinacao.Entiny.postos.Postos;

@Repository
public interface PostosRepository extends JpaRepository<Postos, Integer> {
}
