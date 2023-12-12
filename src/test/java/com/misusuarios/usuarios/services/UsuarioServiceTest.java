package com.misusuarios.usuarios.services;

import com.misusuarios.usuarios.models.usuario.Usuario;
import com.misusuarios.usuarios.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void testObtenerUsuarioPorIdExistente() {
        // Configuración del mock
        Long usuarioId = 1L;
        Usuario usuarioMock = new Usuario();
        usuarioMock.setId(usuarioId);

        when(usuarioRepository.findById(usuarioId)).thenReturn(Optional.of(usuarioMock));

        // Ejecución del método bajo prueba
        Optional<Usuario> resultado = usuarioService.obtenerUsuarioPorId(usuarioId);

        // Verificación del resultado
        assertTrue(resultado.isPresent());
        assertEquals(usuarioId, resultado.get().getId());

        // Verificación de interacciones con el mock
        verify(usuarioRepository, times(1)).findById(usuarioId);
    }

    @Test
    public void testObtenerUsuarioPorIdNoExistente() {
        // Configuración del mock
        Long usuarioId = 2L;

        when(usuarioRepository.findById(usuarioId)).thenReturn(Optional.empty());

        // Ejecución del método bajo prueba
        Optional<Usuario> resultado = usuarioService.obtenerUsuarioPorId(usuarioId);

        // Verificación del resultado
        assertTrue(resultado.isEmpty());

        // Verificación de interacciones con el mock
        verify(usuarioRepository, times(1)).findById(usuarioId);
    }

    @Test
    public void testObtenerUsuariosPorCorreo() {
        // Configuración del mock
        String correo = "correo@example.com";
        Usuario usuarioMock1 = new Usuario();
        usuarioMock1.setId(1L);
        Usuario usuarioMock2 = new Usuario();
        usuarioMock2.setId(2L);

        when(usuarioRepository.findByCorreo(correo)).thenReturn(Arrays.asList(usuarioMock1, usuarioMock2));

        // Ejecución del método bajo prueba
        List<Usuario> resultado = usuarioService.obtenerUsuariosPorCorreo(correo);

        // Verificación del resultado
        assertEquals(2, resultado.size());

        // Verificación de interacciones con el mock
        verify(usuarioRepository, times(1)).findByCorreo(correo);
    }


}

