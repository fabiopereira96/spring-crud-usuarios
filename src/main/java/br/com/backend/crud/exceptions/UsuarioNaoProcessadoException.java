package br.com.backend.crud.exceptions;

import br.com.backend.crud.entities.Usuario;
import br.com.backend.crud.exceptions.models.ResponseErro;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsuarioNaoProcessadoException extends ResponseStatusException {

    public static final HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

    private final Usuario usuario;
    private final ResponseErro responseErro;

    public UsuarioNaoProcessadoException(Usuario usuario, Throwable cause, ResponseErro responseErro){
        super(status, responseErro.getMensagem(), cause);
        this.usuario = usuario;
        this.responseErro = responseErro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ResponseErro getResponseErro() {
        return responseErro;
    }
}
