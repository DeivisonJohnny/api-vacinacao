package com.dev_johnny.api_vacinacao.Exception;

import com.dev_johnny.api_vacinacao.DTO.RestResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RestResponse> handlePostoNotFoundException(EntityNotFoundException ex) {
        // Cria a mensagem de erro personalizada
        String message = ex.getMessage() != null ? ex.getMessage() : "Recurso não encontrado";

        // Retorna a resposta HTTP com status 404 e corpo JSON
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new RestResponse(404, message));
    }
}
