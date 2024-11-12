package com.dev_johnny.api_vacinacao.Repository;

import com.dev_johnny.api_vacinacao.Entiny.Postos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostosRepository extends JpaRepository<Postos , Integer> {
}
