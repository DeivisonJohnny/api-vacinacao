package com.dev_johnny.api_vacinacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev_johnny.api_vacinacao.Entiny.vacinas.Vacinas;

@Repository
public interface VacinasRepository extends JpaRepository<Vacinas, Integer> {
}
