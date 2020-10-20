package com.github.kreker721425.db.services;

import com.github.kreker721425.db.models.Request;
import com.github.kreker721425.db.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public void save(Request request) {
        requestRepository.save(request);
    }

    public void delete(Request request) {
        requestRepository.delete(request);
    }

    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    public Request findByNumber(String number) {
        return requestRepository.findByNumber(number);
    }
}
