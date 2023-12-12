package com.misusuarios.usuarios.services;

import com.misusuarios.usuarios.models.usuario.Usuario;
import com.misusuarios.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerUsuarioPorId(Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerUsuarioPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    @Transactional(readOnly = true)
    public List<Usuario> obtenerUsuariosPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) {
        // Verifica si el usuario existe antes de actualizar
        if (usuarioRepository.existsById(usuario.getId())) {
            return usuarioRepository.save(usuario);
        } else {
            return null; // El usuario no existe, maneja este caso según tu lógica de negocio
        }
    }

    @Transactional
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}