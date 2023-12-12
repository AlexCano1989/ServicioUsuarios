package com.misusuarios.usuarios.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.misusuarios.usuarios.models.usuario.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void testGuardarYRecuperarUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setNombre("UsuarioTest");
        usuario.setCorreo("test@example.com");

        // Act
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        Optional<Usuario> usuarioRecuperado = usuarioRepository.findById(usuarioGuardado.getId());

        // Assert
        assertThat(usuarioRecuperado).isPresent();
        assertThat(usuarioRecuperado.get().getNombre()).isEqualTo("UsuarioTest");
        assertThat(usuarioRecuperado.get().getCorreo()).isEqualTo("test@example.com");
    }

    @Test
    public void testBuscarPorNombre() {
        // Arrange
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Usuario1");
        usuario1.setCorreo("correo1@example.com");

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Usuario2");
        usuario2.setCorreo("correo2@example.com");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        // Act
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByNombre("Usuario1");

        // Assert
        assertThat(usuarioEncontrado).isPresent();
        assertThat(usuarioEncontrado.get().getNombre()).isEqualTo("Usuario1");
        assertThat(usuarioEncontrado.get().getCorreo()).isEqualTo("correo1@example.com");
    }

    @Test
    public void testBuscarPorCorreo() {
        // Arrange
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Usuario1");
        usuario1.setCorreo("correo1@example.com");

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Usuario2");
        usuario2.setCorreo("correo2@example.com");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        // Act
        List<Usuario> usuariosEncontrados = usuarioRepository.findByCorreo("correo1@example.com");

        // Assert
        assertThat(usuariosEncontrados).hasSize(1);
        assertThat(usuariosEncontrados.get(0).getNombre()).isEqualTo("Usuario1");
        assertThat(usuariosEncontrados.get(0).getCorreo()).isEqualTo("correo1@example.com");
    }
}