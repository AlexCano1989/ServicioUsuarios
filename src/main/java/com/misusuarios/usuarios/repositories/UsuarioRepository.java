package com.misusuarios.usuarios.repositories;
import com.misusuarios.usuarios.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Método para buscar un usuario por su nombre
    Optional<Usuario> findByNombre(String nombre);

    // Método para buscar usuarios por su correo
    List<Usuario> findByCorreo(String correo);

    // Puedes agregar otros métodos de consulta según tus necesidades

}