package com.crio.api.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "usuario")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 255)
    private String nomeCompleto;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(nullable = false)
    private int tipo;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
