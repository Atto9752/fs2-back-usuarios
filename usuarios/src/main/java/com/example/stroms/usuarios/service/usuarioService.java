package com.example.stroms.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stroms.usuarios.model.dto.usuario;
import com.example.stroms.usuarios.repository.usuarioRepositorio;

@Service
public class usuarioService {

    @Autowired //para que se inicie junto con el repo y no se desconecten uno del otro
    private usuarioRepositorio usuarioRepo;

    public List<usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    public usuario guardarUsuario(usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioRepo.deleteById(id);
    }

    public usuario obtenerUsuarioPorId(int id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    public usuario actualizarUsuario(int id, usuario usuarioActualizado) {
        usuario usuarioExistente = usuarioRepo.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
            usuarioExistente.setContrasena(usuarioActualizado.getContrasena());
            usuarioExistente.setRol(usuarioActualizado.getRol());
            return usuarioRepo.save(usuarioExistente);
        }
        return null;
    }


}
