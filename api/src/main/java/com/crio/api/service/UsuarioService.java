package com.crio.api.service;

import com.crio.api.domain.usuario.Usuario;
import com.crio.api.domain.usuario.UsuarioRequestDTO;
import com.crio.api.repositorie.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(UsuarioRequestDTO data){
        Usuario newUsuario = new Usuario();
        //preenche os dados do usuario
        newUsuario.setNomeCompleto(data.nomeCompleto());
        newUsuario.setEmail(data.email());
        newUsuario.setSenha(data.senha());
        newUsuario.setTipo(data.tipo());
        usuarioRepository.save(newUsuario);
        return newUsuario;
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserById(UUID id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
    }

    public Usuario updateUser(UUID id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario uptadeUsuario = getUserById(id);
        uptadeUsuario.setNomeCompleto(usuarioRequestDTO.nomeCompleto());
        uptadeUsuario.setEmail(usuarioRequestDTO.email());
        uptadeUsuario.setSenha(usuarioRequestDTO.senha());
        uptadeUsuario.setTipo(usuarioRequestDTO.tipo());
        uptadeUsuario.setUpdatedAt(LocalDateTime.now());
        return usuarioRepository.save(uptadeUsuario);
    }

    public void deleteUser(UUID id) {
        Usuario usuario = getUserById(id);
        usuarioRepository.delete(usuario);
    }
}
