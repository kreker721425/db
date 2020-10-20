package com.github.kreker721425.db.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Table(name = "ilc")
public class ILC {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "objective_id", nullable = false)
    private Objective objective;

    private String text;

    public ILC(String text, Objective objective) {
        this.text = text;
        this.objective = objective;
    }
}
