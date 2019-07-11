package br.com.backend.crud.utils;

import br.com.backend.crud.entities.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseEntityUtil {

    public static ResponseEntity trataRetornoPorLista(List<Usuario> usuarios){
        return usuarios.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT) :
                new ResponseEntity(usuarios, HttpStatus.OK);
    }
}
