package com.dev_johnny.api_vacinacao.Entiny.usuarios;

public enum UsuariosRoles {

    ADMIN("admin"),
    USER("user");

    private String role;

    UsuariosRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
