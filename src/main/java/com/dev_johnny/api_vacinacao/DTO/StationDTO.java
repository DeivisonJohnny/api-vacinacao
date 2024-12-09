package com.dev_johnny.api_vacinacao.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StationDTO(
        @NotNull(message = "O ID não pode ser nulo") int id,
        @NotBlank(message = "O nome não pode ser vazio") String name,
        @NotBlank(message = "O endereço não pode ser vazio") String endereco,
        @NotBlank(message = "A latitude não pode ser vazia") String latitude,
        @NotBlank(message = "A longitude não pode ser vazia") String longitude) {
}
