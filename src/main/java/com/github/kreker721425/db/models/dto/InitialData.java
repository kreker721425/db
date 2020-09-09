package com.github.kreker721425.db.models.dto;

import com.github.kreker721425.db.models.Objective;
import com.github.kreker721425.db.models.Request;
import lombok.Data;

import java.util.List;

@Data
public class InitialData {
    Request request;
    List<Objective> objectives;

    public InitialData(Request request, List<Objective> objectives) {
        this.request = request;
        this.objectives = objectives;
    }
}
