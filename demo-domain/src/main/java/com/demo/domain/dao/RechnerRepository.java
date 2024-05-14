package com.demo.domain.dao;


import com.demo.domain.model.Rechner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RechnerRepository extends JpaRepository<Rechner, Long> {
    Rechner findByUuid(UUID uuid);

}

