package com.crio.api.domain.convite;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name="Convite")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Convite {
    @Id
    @GeneratedValue UUID id;

    @Column(nullable = false)
    private Boolean confirmacao_presenca;
}
