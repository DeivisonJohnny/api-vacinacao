package com.dev_johnny.api_vacinacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev_johnny.api_vacinacao.Entiny.vaccines.Vaccine;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Integer> {
}
