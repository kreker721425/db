package com.github.kreker721425.db.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "io")
public class OI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "objective_id", nullable = false)
    private Objective objective;

    private String text;

    public OI(String text, Objective objective) {
        this.text = text;
        this.objective = objective;
    }
}
