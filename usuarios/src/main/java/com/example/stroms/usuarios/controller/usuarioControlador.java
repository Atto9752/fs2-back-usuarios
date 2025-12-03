package com.example.stroms.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stroms.usuarios.model.dto.usuario;
import com.example.stroms.usuarios.service.usuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")
public class usuarioControlador {

    @Autowired //para que cuando se levante el controlador se inicie el servicio 
    private usuarioService servicio;


    @GetMapping
    public List<usuario> listarUsuarios() {
        return servicio.listarUsuarios();
    }

    @PostMapping
    public usuario guardarUsuario(usuario usuario) {
        return servicio.guardarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(int id) {
        servicio.eliminarUsuario(id);
    }

    @GetMapping("/{id}")
    public usuario buscarUsuario(int id) {
        return servicio.buscarUsuario(id);
    }

    @PutMapping("/{id}")    
    public usuario actualizarUsuario(int id, usuario usuarioActualizado) {
        return servicio.actualizarUsuario(id, usuarioActualizado);
    }
}
