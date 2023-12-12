package com.misusuarios.usuarios.models.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;


    public Long getId() {
        return null;
    }

    public void setId(Long id) {
    }

    public void setNombre(String usuarioTest) {
    }

    public void setCorreo(String s) {
    }

    public boolean getNombre() {
        return false;
    }

    public boolean getCorreo() {
        return false;
    }
}