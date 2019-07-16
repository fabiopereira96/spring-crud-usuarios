package br.com.backend.crud.exceptions;

import br.com.backend.crud.entities.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;

public class UsuarioNaoEncontradoException extends ResponseStatusException implements Supplier<Usuario> {

    private static final HttpStatus status = HttpStatus.NOT_FOUND;

    public UsuarioNaoEncontradoException(){
        super(status);
    }

    public UsuarioNaoEncontradoException(String mensagem){
        super(status, mensagem);
    }

    @Override
    public Usuario get() {
        return null;
    }
}
