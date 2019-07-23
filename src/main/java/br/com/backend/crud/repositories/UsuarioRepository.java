package br.com.backend.crud.repositories;

import br.com.backend.crud.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
