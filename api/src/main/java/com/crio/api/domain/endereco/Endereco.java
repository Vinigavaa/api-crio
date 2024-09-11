package com.crio.api.domain.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "endereco")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue
    UUID id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, length = 2)
    private String uf;
}
