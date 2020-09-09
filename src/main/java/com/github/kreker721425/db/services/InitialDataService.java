package com.github.kreker721425.db.services;

import com.github.kreker721425.db.models.Objective;
import com.github.kreker721425.db.models.Request;
import com.github.kreker721425.db.models.dto.InitialData;
import com.github.kreker721425.db.repositories.ObjectiveRepository;
import com.github.kreker721425.db.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitialDataService {

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Autowired
    private RequestRepository requestRepository;

    public void save(InitialData initialData){
        for (Objective o: initialData.getObjectives()) {
            o.setRequest(initialData.getRequest());
            objectiveRepository.save(o);
        }
        requestRepository.save(initialData.getRequest());
    }


    public void delete(InitialData initialData){
        requestRepository.delete(initialData.getRequest());
    }

    public List<InitialData> findAll(){
        List<InitialData> list = new ArrayList<>();
        for (Request request: requestRepository.findAll()) {
            list.add(new InitialData(request,request.getObjectives()));
        }
        return list;
    }

    public List<InitialData> findByNumber(long number){
        List<InitialData> list = new ArrayList<>();
        for (Request request : requestRepository.findByNumber(number)) {
            list.add(new InitialData(request,requestRepository.findAllByObjectives(request)));
        }
        return list;
    }

}
