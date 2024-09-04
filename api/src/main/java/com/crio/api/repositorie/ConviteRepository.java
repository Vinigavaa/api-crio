package com.crio.api.repositorie;

import com.crio.api.domain.convite.Convite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConviteRepository extends JpaRepository<Convite, UUID> {
}
