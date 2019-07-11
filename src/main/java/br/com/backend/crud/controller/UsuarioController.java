package br.com.backend.crud.controller;

import br.com.backend.crud.entities.Usuario;
import br.com.backend.crud.exceptions.UsuarioNaoEncontradoException;
import br.com.backend.crud.repositories.UsuarioRepository;
import br.com.backend.crud.utils.ResponseEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity consultar(){
        try {
            return ResponseEntityUtil.trataRetornoPorLista(repository.findAll());
        } catch (Exception e){
            System.out.println("Não foi possível consultar os usuarios." + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> cadastrar(@RequestBody Usuario usuario){
        try {
            repository.save(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            System.out.println("Não foi possível salvar o usuario." + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ResponseEntity consultarPorCodigo(@PathVariable Integer codigo){

        try {
            Optional<Usuario> usuario = repository.findById(codigo);
            usuario.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado."));

            return new ResponseEntity(usuario.get(), HttpStatus.OK);

        } catch (UsuarioNaoEncontradoException e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            System.out.println("Não foi possível consultar o Usuario: " + codigo + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @RequestMapping(value = "/paginados", method = RequestMethod.GET)
    public ResponseEntity consultarPaginados(
            @RequestParam int page,
            @RequestParam int size){

        try {
            Page<Usuario> usuarios = repository.findAll(PageRequest.of(page, size));

            return usuarios.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT) :
                    new ResponseEntity(usuarios, HttpStatus.OK);

        } catch (Exception e){
            System.out.println("Não foi possível consultar os usuarios." + e.getMessage());
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
