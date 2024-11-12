package com.dev_johnny.api_vacinacao.Repository;

import com.dev_johnny.api_vacinacao.Entiny.Vacinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinasRepository extends JpaRepository<Vacinas, Integer> {
}
