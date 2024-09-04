package com.crio.api.domain.evento;

import com.crio.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name="Evento")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue UUID id;

    @Column(nullable = false, length = 255)
    private String titulo;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fim;

    @Column(nullable = false, length = 255)
    private String local;

    @Column(nullable = false)
    private Boolean privado;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    public enum PublicoAlvo {
    }
}
