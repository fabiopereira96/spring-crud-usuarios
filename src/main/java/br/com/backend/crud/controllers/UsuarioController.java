package br.com.backend.crud.controllers;

import br.com.backend.crud.entities.Usuario;
import br.com.backend.crud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity consultar() {
        return service.buscaTodos();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrar(@RequestBody Usuario usuario) {
        service.cadastrar(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ResponseEntity consultarPorCodigo(@PathVariable Integer codigo){
        return service.buscaPorCodigo(codigo);
    }

    @RequestMapping(value = "/paginados", method = RequestMethod.GET)
    public ResponseEntity consultarPaginados(
            @RequestParam int page,
            @RequestParam int size){
        return service.buscaPorPagina(page, size);
    }

}
