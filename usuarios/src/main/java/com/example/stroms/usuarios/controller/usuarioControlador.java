package com.example.stroms.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stroms.usuarios.model.dto.usuario;
import com.example.stroms.usuarios.service.usuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class usuarioControlador {

    @Autowired //para que cuando se levante el controlador se inicie el servicio 
    private usuarioService servicio;

    public List<usuario> listarUsuarios() {
        return servicio.listarUsuarios();
    }

    public usuario guardarUsuario(usuario usuario) {
        return servicio.guardarUsuario(usuario);
    }

    public void eliminarUsuario(int id) {
        servicio.eliminarUsuario(id);
    }

    public usuario buscarUsuario(int id) {
        return servicio.buscarUsuario(id);
    }

    public usuario actualizarUsuario(int id, usuario usuarioActualizado) {
        return servicio.actualizarUsuario(id, usuarioActualizado);
    }
}
