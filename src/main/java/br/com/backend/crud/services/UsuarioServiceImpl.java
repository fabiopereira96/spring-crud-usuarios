package br.com.backend.crud.services;

import br.com.backend.crud.entities.Usuario;
import br.com.backend.crud.exceptions.UsuarioNaoProcessadoException;
import br.com.backend.crud.exceptions.models.ResponseErro;
import br.com.backend.crud.messages.UsuarioMessage;
import br.com.backend.crud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//TODO
// Criar usuarioModel para trafegar durante as requisições e converter para a entidade apenas na hora de persistir
// no banco de dados.
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void cadastrar(Usuario usuario) {
        try {
            repository.save(usuario);
        } catch (Exception e){
            throw new UsuarioNaoProcessadoException(usuario, e,
                    new ResponseErro(new Date(), UsuarioMessage.USUARIO_CADASTRO, UsuarioMessage.USUARIO_CADASTRO_MENSAGEM));
        }
    }

    @Override
    public void deletar(Integer codigo){
        try {
            repository.deleteById(codigo);
        } catch (Exception e){
            Usuario usuario = new Usuario();
            usuario.setCodigo(codigo);
            
            throw new UsuarioNaoProcessadoException(usuario, e,
                    new ResponseErro(new Date(), UsuarioMessage.USUARIO_DELETE, UsuarioMessage.USUARIO_DELETE_MENSAGEM));
        }
    }

    @Override
    public ResponseEntity buscaTodos() {
        try {
            List<Usuario> usuarios = repository.findAll();

            return usuarios.isEmpty() ? new ResponseEntity(HttpStatus.NO_CONTENT) :
                    new ResponseEntity(usuarios, HttpStatus.OK);

        } catch (Exception e){
            throw new UsuarioNaoProcessadoException(null, e,
                    new ResponseErro(new Date(), UsuarioMessage.USUARIO_CONSULTA, UsuarioMessage.USUARIO_CONSULTA_MENSAGEM));
        }
    }

    @Override
    public ResponseEntity buscaPorPagina(int page, int size) {
        try {
            Page<Usuario> usuarios = repository.findAll(PageRequest.of(page, size));

            return new ResponseEntity(usuarios, HttpStatus.OK);

        } catch (Exception e){
            throw new UsuarioNaoProcessadoException(null, e,
                    new ResponseErro(new Date(), UsuarioMessage.USUARIO_CONSULTA,
                            String.format(UsuarioMessage.USUARIO_CONSULTA_PAGINA_MENSAGEM, size, page)));
        }
    }

    @Override
    public ResponseEntity buscaPorCodigo(Integer codigo) {
        try {
            Optional<Usuario> usuario = repository.findById(codigo);
            usuario.orElseThrow(() -> new IllegalStateException());

            return new ResponseEntity(usuario.get(), HttpStatus.OK);

        } catch (IllegalStateException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            Usuario usuario = new Usuario();
            usuario.setCodigo(codigo);

            throw new UsuarioNaoProcessadoException(usuario, e,
                    new ResponseErro(new Date(), UsuarioMessage.USUARIO_CONSULTA_POR_CODIGO, UsuarioMessage.USUARIO_CONSULTA_MENSAGEM));
        }
    }
}
