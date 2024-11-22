package com.dev_johnny.api_vacinacao.DTO;

import com.dev_johnny.api_vacinacao.Entiny.usuarios.UsuariosRoles;

public record RegisterDTO(String name, String username, String password, UsuariosRoles role) {
}
