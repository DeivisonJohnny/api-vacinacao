package com.dev_johnny.api_vacinacao.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VacinaDTO(@NotNull(message = "O id não pode ser null") int id, @NotBlank(message = "O nome não pode ser vázio") String name, @NotBlank(message = "Descrição não pode ser vázio") String description, @NotBlank(message = "Tipo nãpo pode ser vázio") String tipo) {
}
