package com.github.kreker721425.db.services;

import com.github.kreker721425.db.error.RequestNotFoundException;
import com.github.kreker721425.db.models.MeasureEnum;
import com.github.kreker721425.db.models.Objective;
import com.github.kreker721425.db.models.Request;
import com.github.kreker721425.db.models.dto.InitialData;
import com.github.kreker721425.db.models.dto.ObjectiveCreateDto;
import com.github.kreker721425.db.models.dto.ObjectiveDto;
import com.github.kreker721425.db.models.dto.RequestShowPageOneDto;
import com.github.kreker721425.db.repositories.ObjectiveRepository;
import com.github.kreker721425.db.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InitialDataService {

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Autowired
    private RequestRepository requestRepository;

    public void save(InitialData initialData) {
        objectiveRepository.saveAll(initialData.getObjectives());
        initialData.getObjectives().forEach(objectiveRepository::save);
        requestRepository.save(initialData.getRequest());
    }

    public void addNewObjective(ObjectiveCreateDto dto) {
        final Objective entity = new Objective();

        entity.setCityWork(dto.getCityWork());
        // e.t.c.

        entity.setIlcService(dto.getIlcService().stream().map(MeasureEnum::name).collect(Collectors.joining(",")));

        entity.setRequest(requestRepository.findById(dto.getRequestId()).orElseThrow(RequestNotFoundException::new));
        objectiveRepository.save(entity);
    }

    //переделать на show dto
    public List<ObjectiveCreateDto> getObjective() {
        return objectiveRepository.findAll()
                .stream()
                .map(entity -> {
                    ObjectiveCreateDto dto = new ObjectiveCreateDto();

                    dto.setIlcService(Arrays.stream(Objects.requireNonNull(StringUtils.split(entity.getIlcService(), ",")))
                            .map(MeasureEnum::valueOf)
                            .collect(Collectors.toList()));



                    // для того чтобы переделать из enum в список названий

                    String names = dto.getIlcService().stream().map(MeasureEnum::getTitle).collect(Collectors.joining(", "));

                    return dto;
                })
                .collect(Collectors.toList());
    }


    public void delete(InitialData initialData) {
        requestRepository.delete(initialData.getRequest());
    }

    public List<InitialData> findAll() {
        List<InitialData> list = new ArrayList<>();
        for (Request request : requestRepository.findAll()) {
            list.add(new InitialData(request, request.getObjectives()));
        }
        return list;
    }

    public List<RequestShowPageOneDto> findAllDto() {
        return requestRepository.findAll()
                .stream()
                .map(entity -> RequestShowPageOneDto.of(
                        entity.getId(),
                        entity.getNumber(),
                        entity.getTypeCustomer(),
                        entity.getNameCustomer(),
                        entity.getAddressCustomer(),
                        entity.getTypeOwner(),
                        entity.getNameOwner(),
                        entity.getAddressOwner(),
                        entity.getObjectives()
                                .stream()
                                .map(o -> ObjectiveDto.of(
                                        o.getId(),
                                        o.getOiService(),
                                        o.getIlcService(),
                                        o.getDistrictWork(),
                                        o.getCityWork(),
                                        o.getStreetWork(),
                                        o.getHouseWork(),
                                        o.getResponsible(),
                                        o.getExecutor(),
                                        o.getDeadline(),
                                        o.isStatus(),
                                        o.getDateCompleted()
                                )).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public List<InitialData> findByNumber(long number) {
        List<InitialData> list = new ArrayList<>();
        for (Request request : requestRepository.findByNumber(number)) {
            list.add(new InitialData(request, requestRepository.findAllByObjectives(request)));
        }
        return list;
    }

}
