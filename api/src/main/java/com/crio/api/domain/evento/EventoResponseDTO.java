package com.crio.api.domain.evento;

import com.crio.api.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public record EventoResponseDTO(
        UUID id,
        String titulo,
        String descricao,
        String local,
        LocalDateTime inicio,
        LocalDateTime fim,
        Boolean privado,
        String link_evento,
        String como_chegar,
        String link_forms,
        Usuario usuario) {
}
