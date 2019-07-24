package br.com.backend.crud.services;

import br.com.backend.crud.entities.Usuario;
import org.springframework.http.ResponseEntity;

public interface UsuarioService {

    void cadastrar(Usuario usuario);

    void deletar(Integer codigo);

    ResponseEntity buscaTodos();

    ResponseEntity buscaPorPagina(int page, int size);

    ResponseEntity buscaPorCodigo(Integer codigo);

}
