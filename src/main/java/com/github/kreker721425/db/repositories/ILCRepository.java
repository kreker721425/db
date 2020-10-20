package com.github.kreker721425.db.repositories;

import com.github.kreker721425.db.models.ILC;
import com.github.kreker721425.db.models.Objective;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILCRepository extends JpaRepository<ILC, Long> {
    List<ILC> findAllByObjective(Objective objective);
}
