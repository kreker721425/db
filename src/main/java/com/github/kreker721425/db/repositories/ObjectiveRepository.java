package com.github.kreker721425.db.repositories;

import com.github.kreker721425.db.models.Objective;
import com.github.kreker721425.db.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObjectiveRepository extends JpaRepository<Objective,Long> {
    List<Objective> findAllByRequest(Request request);
    List<Objective> findAll();
}
