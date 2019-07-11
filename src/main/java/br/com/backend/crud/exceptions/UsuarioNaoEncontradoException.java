package br.com.backend.crud.exceptions;

import br.com.backend.crud.entities.Usuario;

import java.util.function.Supplier;

public class UsuarioNaoEncontradoException extends Exception implements Supplier<Usuario> {

    public UsuarioNaoEncontradoException(String mensagem){
        super(mensagem);
    }

    @Override
    public Usuario get() {
        return null;
    }
}
