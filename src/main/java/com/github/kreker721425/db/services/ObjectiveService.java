package com.github.kreker721425.db.services;

import com.github.kreker721425.db.constants.ServicesConstants;
import com.github.kreker721425.db.models.Objective;
import com.github.kreker721425.db.models.Request;
import com.github.kreker721425.db.repositories.ObjectiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectiveService {

    private final ObjectiveRepository objectiveRepository;

    private final OIService oiService;

    private final ILCService ilcService;

    public ObjectiveService(ObjectiveRepository objectiveRepository, OIService oiService, ILCService ilcService) {
        this.objectiveRepository = objectiveRepository;
        this.oiService = oiService;
        this.ilcService = ilcService;
    }

    public void save(Objective objective, Request request) {
        objective.setRequest(request);
        objectiveRepository.save(objective);
    }

    public void delete(Objective objective) {
        objectiveRepository.delete(objective);
    }

    public List<Objective> findAll() {
        return objectiveRepository.findAll();
    }

    public Objective findById(long id) {
        return objectiveRepository.findById(id).orElse(null);
    }

    public List<Objective> findAllByRequest(Request request) {
        return objectiveRepository.findAllByRequest(request);
    }

    public void saveMeasuresByObjective(Objective objective) {
        if (objective.isProjectRTO()) oiService.save(objective, ServicesConstants.EXPERTISE_PROJECT_RTO);
        else oiService.deleteByArgument(objective, ServicesConstants.EXPERTISE_PROJECT_RTO);
        if (objective.isCommissioningRTO()) oiService.save(objective, ServicesConstants.EXPERTISE_COMMISSIONING_RTO);
        else oiService.deleteByArgument(objective, ServicesConstants.EXPERTISE_COMMISSIONING_RTO);
        if (objective.isIff()) oiService.save(objective, ServicesConstants.EXPERTISE_IFF);
        else oiService.deleteByArgument(objective, ServicesConstants.EXPERTISE_IFF);
        if (objective.isResearchResults()) oiService.save(objective, ServicesConstants.EXPERTISE_RESEARCH_RESULTS);
        else oiService.deleteByArgument(objective, ServicesConstants.EXPERTISE_RESEARCH_RESULTS);

        if (!oiService.findAllByObjective(objective).isEmpty()) objective.setOi(true);

        if (objective.isNoise()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_NOISE);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_NOISE);
        if (objective.isVibration()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_VIBRATION);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_VIBRATION);
        if (objective.isMicroclimate()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_MICROCLIMATE);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_MICROCLIMATE);
        if (objective.isIllumination()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_ILLUMINATION);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_ILLUMINATION);
        if (objective.isLaserRadiation()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_LASER_RADIATION);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_LASER_RADIATION);
        if (objective.isAeroions()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_AEROIONS);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_AEROIONS);
        if (objective.isUltrasound()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_ULTRASOUND);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_ULTRASOUND);
        if (objective.isInfrasound()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_INFRASOUND);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_INFRASOUND);
        if (objective.isVch()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_VCH);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_VCH);
        if (objective.isVdt()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_VDT);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_VDT);
        if (objective.isSvch()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_SVCH);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_SVCH);
        if (objective.isM50Hg()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_50HG);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_50HG);
        if (objective.isPmp()) ilcService.save(objective, ServicesConstants.MEASUREMENTS_PMP);
        else ilcService.deleteByArgument(objective, ServicesConstants.MEASUREMENTS_PMP);

        if (!ilcService.findAllByObjective(objective).isEmpty()) objective.setIlc(true);
        save(objective, objective.getRequest());
    }

    public void setCorrectDate(Objective objective, String date) {
        String[] str = date.split("-");
        objective.setDeadline(str[2] + "." + str[1] + "." + str[0]);
    }

}
