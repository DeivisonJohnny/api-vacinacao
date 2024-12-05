package com.dev_johnny.api_vacinacao.Exception;

public class PostoException extends RuntimeException{
    PostoException(String mensagem) {
        super(mensagem);
    }
}
