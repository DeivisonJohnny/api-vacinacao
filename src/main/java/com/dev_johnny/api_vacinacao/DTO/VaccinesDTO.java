package com.dev_johnny.api_vacinacao.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VaccinesDTO(
      @NotNull(message = "The id cannot be null") int id,
      @NotBlank(message = "The name cannot be empty") String name,
      @NotBlank(message = "Description cannot be empty") String description,
      @NotBlank(message = "Type cannot be empty") String tipo) {
}
