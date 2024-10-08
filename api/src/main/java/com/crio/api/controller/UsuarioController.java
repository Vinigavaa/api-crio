package com.crio.api.controller;

import com.crio.api.domain.usuario.Usuario;
import com.crio.api.domain.usuario.UsuarioRequestDTO;
import com.crio.api.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    //retornar todos os usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> usuarios = this.usuarioService.getAllUsers();
        //retorna list todos os usuarios
        return ResponseEntity.ok(usuarios);
    }

    //retornar o usuario pelo Id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id")UUID id){
        Usuario usuario = this.usuarioService.getUserById(id);
        return ResponseEntity.ok(usuario);
    }

    //atualizar os dados do usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable("id") UUID id, @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        Usuario updatedUsuario = this.usuarioService.updateUser(id, usuarioRequestDTO);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") UUID id){
        this.usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
