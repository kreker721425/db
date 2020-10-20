package com.github.kreker721425.db.services;

import com.github.kreker721425.db.models.ILC;
import com.github.kreker721425.db.models.Objective;
import com.github.kreker721425.db.repositories.ILCRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ILCService {

    private final ILCRepository ilcRepository;

    public ILCService(ILCRepository ilcRepository) {
        this.ilcRepository = ilcRepository;
    }

    public void save(Objective objective, String text) {
        for (ILC ilc : findAllByObjective(objective)) {
            if (ilc.getText().equals(text))
                return;
        }
        ILC ilc = new ILC(text, objective);
        ilcRepository.save(ilc);
    }

    public void deleteByArgument(Objective objective, String text) {
        List<ILC> list = findAllByObjective(objective);
        if (list == null || list.isEmpty())
            return;
        for (ILC ilc : list) {
            if (ilc.getText().equals(text)) {
                delete(ilc);
                return;
            }
        }
    }

    public void delete(ILC ilc) {
        ilcRepository.delete(ilc);
    }

    public List<ILC> findAllByObjective(Objective objective) {
        return ilcRepository.findAllByObjective(objective);
    }
}
