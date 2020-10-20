package com.github.kreker721425.db.repositories;

import com.github.kreker721425.db.models.OI;
import com.github.kreker721425.db.models.Objective;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OIRepository extends JpaRepository<OI, Long> {
    List<OI> findAllByObjective(Objective objective);
}
