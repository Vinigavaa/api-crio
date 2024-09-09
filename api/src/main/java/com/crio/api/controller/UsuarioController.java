package com.crio.api.controller;

import com.crio.api.domain.usuario.Usuario;
import com.crio.api.domain.usuario.UsuarioRequestDTO;
import com.crio.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Usuario> create (
            @RequestParam("nomecompleto") String nomeCompleto,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("tipo") int tipo){
        UsuarioRequestDTO usuarioRequestDTO = new UsuarioRequestDTO(nomeCompleto, email, senha, tipo);
        Usuario newUsuario = this.usuarioService.createUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(newUsuario);
    }
}
