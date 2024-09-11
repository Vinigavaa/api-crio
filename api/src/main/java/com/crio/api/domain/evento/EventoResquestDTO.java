package com.crio.api.domain.evento;

import com.crio.api.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record EventoResquestDTO(
        String titulo,
        String descricao,
        String local,
        LocalDateTime inicio,
        LocalDateTime fim,
        Boolean privado,
        String link_evento,
        String como_chegar,
        String link_forms,
        Usuario usuario

) {
}
