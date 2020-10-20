package com.github.kreker721425.db.services;

import com.github.kreker721425.db.models.ILC;
import com.github.kreker721425.db.models.OI;
import com.github.kreker721425.db.models.Objective;
import com.github.kreker721425.db.repositories.OIRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OIService {

    private final OIRepository oiRepository;

    public OIService(OIRepository oiRepository) {
        this.oiRepository = oiRepository;
    }

    public void save(Objective objective, String text) {
        for (OI oi : findAllByObjective(objective)) {
            if (oi.getText().equals(text))
                return;
        }
        OI oi = new OI(text, objective);
        oiRepository.save(oi);
    }

    public void deleteByArgument(Objective objective, String text) {
        List<OI> list = findAllByObjective(objective);
        if (list == null || list.isEmpty())
            return;
        for (OI oi : list) {
            if (oi.getText().equals(text)) {
                delete(oi);
                return;
            }
        }
    }

    public void delete(OI OI) {
        oiRepository.delete(OI);
    }

    public List<OI> findAllByObjective(Objective objective) {
        return oiRepository.findAllByObjective(objective);
    }
}
