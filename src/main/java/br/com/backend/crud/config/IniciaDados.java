package br.com.backend.crud.config;

import br.com.backend.crud.entities.Usuario;
import br.com.backend.crud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IniciaDados implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<Usuario> usuarios = repository.findAll();

        if(usuarios.isEmpty()){
            criarUsuario("Usuario 1", "usuario1@email.com", "senha1");
        }
    }

    private void criarUsuario(String nome, String email, String senha){
        repository.save(new Usuario(nome, email, senha));
    }
}
