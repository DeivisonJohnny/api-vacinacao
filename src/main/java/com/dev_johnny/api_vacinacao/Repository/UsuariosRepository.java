package com.dev_johnny.api_vacinacao.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.dev_johnny.api_vacinacao.Entiny.usuarios.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    UserDetails findByUsername(String username);
}
