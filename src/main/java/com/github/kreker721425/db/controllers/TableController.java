package com.github.kreker721425.db.controllers;

import com.github.kreker721425.db.models.Objective;
import com.github.kreker721425.db.models.Request;
import com.github.kreker721425.db.services.ObjectiveService;
import com.github.kreker721425.db.services.RequestService;
import com.github.kreker721425.db.services.UserService;
import com.github.kreker721425.db.utils.DownloadUtils;
import com.github.kreker721425.db.utils.UploadUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.IOException;


@Controller
public class TableController {

    private final UserService userService;

    private final ServletContext servletContext;

    private final ObjectiveService objectiveService;

    private final RequestService requestService;

    private final String UPLOAD_PATH_REQUESTS_FILES = "E:/Java_Projects/db/files/requests";

    private final String UPLOAD_PATH_MEASURE_FILES = "E:/Java_Projects/db/files/measures";

    public TableController(ObjectiveService objectiveService, RequestService requestService, ServletContext servletContext, UserService userService) {
        this.objectiveService = objectiveService;
        this.requestService = requestService;
        this.servletContext = servletContext;
        this.userService = userService;
    }

    @GetMapping("/")
    public String table(Model model) {
        model.addAttribute("listR", requestService.findAll());
        model.addAttribute("list", objectiveService.findAll());
        return "table";
    }

    @GetMapping("/download_request_file/{filename}")
    public ResponseEntity<ByteArrayResource> downloadRequestFile(@PathVariable String filename)
            throws IOException {

        return DownloadUtils.getFile(filename, UPLOAD_PATH_REQUESTS_FILES, servletContext);
    }


    @GetMapping("/download_measure_file/{filename}")
    public ResponseEntity<ByteArrayResource> downloadMeasureFile(@PathVariable String filename)
            throws IOException {

        return DownloadUtils.getFile(filename, UPLOAD_PATH_MEASURE_FILES, servletContext);
    }

    @GetMapping("add_request")
    public String addRequestShow(Model model) {
        model.addAttribute("users", userService.findAll());
        return "add_request";
    }


    @PostMapping("add_request")
    public String addRequest(@Valid Request request,
                             @Valid Objective objective,
                             @RequestParam(value = "number") Integer number,
                             @RequestParam(value = "dead_line") String deadline,
                             @RequestParam("file") MultipartFile file,
                             BindingResult bindingResult,
                             Model model
    ) throws IOException {
        request.setNumber(number.toString());

        if (requestService.findByNumber(number.toString()) != null)
            return "add_request";

        if (UploadUtils.uploadFile(UPLOAD_PATH_REQUESTS_FILES, file)) {
            request.setFilename(file.getOriginalFilename());
        }
        objective.setAddressWork();
        objectiveService.setCorrectDate(objective, deadline);
        requestService.save(request);
        objectiveService.save(objective, request);
        objectiveService.saveMeasuresByObjective(objective);
        return "redirect:/";
    }

    @GetMapping("add_objective")
    public String addObjectiveShow(Model model) {
        model.addAttribute("users", userService.findAll());
        return "add_objective";
    }

    @PostMapping("add_objective")
    public String addObjective(@Valid Objective objective,
                               @RequestParam(value = "number") Integer number,
                               @RequestParam(value = "dead_line") String deadline,
                               BindingResult bindingResult,
                               Model model
    ) {

        Request request = requestService.findByNumber(number.toString());

        if (request != null) {
            objective.setAddressWork();
            objectiveService.setCorrectDate(objective, deadline);
            objectiveService.save(objective, request);
            objectiveService.saveMeasuresByObjective(objective);
        } else {
            System.out.println("Нет такого request");
        }
        return "redirect:/";
    }

    @GetMapping("execute_objective/{objective}")
    public String executeShow(@PathVariable Objective objective,
                              Model model) {
        model.addAttribute("objective", objective);
        return "execute_objective";
    }

    @PostMapping("execute_objective")
    public String execute(@Valid @RequestParam("objectiveId") Objective objective,
                          @RequestParam Integer workPlaces,
                          @RequestParam Integer workPlacesNo,
                          @RequestParam Integer measurement,
                          @RequestParam Integer measurementNo,

                          @RequestParam(defaultValue = "0") Integer expertiseProjectRTO,
                          @RequestParam(defaultValue = "0") Integer expertiseCommissioningRTO,
                          @RequestParam(defaultValue = "0") Integer expertiseIFF,
                          @RequestParam(defaultValue = "0") Integer expertiseResearchResults,

                          @RequestParam(defaultValue = "0") Integer measurementsNoise,
                          @RequestParam(defaultValue = "0") Integer measurementsVibration,
                          @RequestParam(defaultValue = "0") Integer measurementsMicroclimate,
                          @RequestParam(defaultValue = "0") Integer measurementsIllumination,
                          @RequestParam(defaultValue = "0") Integer measurementsLaserRadiation,
                          @RequestParam(defaultValue = "0") Integer measurementsAeroions,
                          @RequestParam(defaultValue = "0") Integer measurementsUltrasound,
                          @RequestParam(defaultValue = "0") Integer measurementsInfrasound,
                          @RequestParam(defaultValue = "0") Integer measurementsVCH,
                          @RequestParam(defaultValue = "0") Integer measurementsVDT,
                          @RequestParam(defaultValue = "0") Integer measurementsSVCH,
                          @RequestParam(defaultValue = "0") Integer measurements50Hg,
                          @RequestParam(defaultValue = "0") Integer measurementsPMP,
                          @RequestParam("file") MultipartFile file
    ) throws IOException {
        objective.setWorkPlaces(workPlaces);
        objective.setWorkPlacesNo(workPlacesNo);
        objective.setMeasurement(measurement);
        objective.setMeasurementNo(measurementNo);

        objective.setExpertiseProjectRTO(expertiseProjectRTO);
        objective.setExpertiseCommissioningRTO(expertiseCommissioningRTO);
        objective.setExpertiseIFF(expertiseIFF);
        objective.setExpertiseResearchResults(expertiseResearchResults);

        objective.setMeasurementsNoise(measurementsNoise);
        objective.setMeasurementsVibration(measurementsVibration);
        objective.setMeasurementsMicroclimate(measurementsMicroclimate);
        objective.setMeasurementsIllumination(measurementsIllumination);
        objective.setMeasurementsLaserRadiation(measurementsLaserRadiation);
        objective.setMeasurementsAeroions(measurementsAeroions);
        objective.setMeasurementsUltrasound(measurementsUltrasound);
        objective.setMeasurementsInfrasound(measurementsInfrasound);
        objective.setMeasurementsVCH(measurementsVCH);
        objective.setMeasurementsVDT(measurementsVDT);
        objective.setMeasurementsSVCH(measurementsSVCH);
        objective.setMeasurements50Hg(measurements50Hg);
        objective.setMeasurementsPMP(measurementsPMP);

        if (UploadUtils.uploadFile(UPLOAD_PATH_MEASURE_FILES, file)) {
            objective.setFileMeasure(file.getOriginalFilename());
        }
        objective.setStatus(true);
        objectiveService.save(objective, objective.getRequest());
        return "redirect:/";
    }

    @GetMapping("measure/{objective}")
    public String measureShow(@PathVariable Objective objective,
                              Model model) {
        model.addAttribute("objective", objective);
        return "measure";
    }

    @GetMapping("objective_edit/delete/{objective}")
    public String objectiveDelete(@PathVariable Objective objective) {
        requestService.delete(objective.getRequest());
        return "redirect:/";
    }

    @GetMapping("objective_edit/{objective}")
    public String objectiveEdit(@PathVariable Objective objective, Model model) {
        model.addAttribute("objective", objective);
        model.addAttribute("users", userService.findAll());
        model.addAttribute("yy", objective.getDeadline().split("\\.")[2]);
        model.addAttribute("mm", objective.getDeadline().split("\\.")[1]);
        model.addAttribute("dd", objective.getDeadline().split("\\.")[0]);
        return "objective_edit";
    }

    @PostMapping("objective_edit")
    public String objectiveSave(@RequestParam("objectiveId") Objective objective,
                                @RequestParam Integer number,
                                @RequestParam(value = "typeCustomer") String typeCustomer,
                                @RequestParam String nameCustomer,
                                @RequestParam String addressCustomer,
                                @RequestParam("file") MultipartFile file,
                                @RequestParam String districtWork,
                                @RequestParam String cityWork,
                                @RequestParam String streetWork,
                                @RequestParam String houseWork,
                                @RequestParam(value = "responsible") String responsible,
                                @RequestParam(value = "executor") String executor,
                                @RequestParam(value = "deadline") String deadline,
                                @RequestParam(value = "typeOfPayment") String typeOfPayment,

                                @RequestParam(defaultValue = "false") boolean ProjectRTO,
                                @RequestParam(defaultValue = "false") boolean CommissioningRTO,
                                @RequestParam(defaultValue = "false") boolean IFF,
                                @RequestParam(defaultValue = "false") boolean ResearchResults,

                                @RequestParam(defaultValue = "false") boolean Noise,
                                @RequestParam(defaultValue = "false") boolean Vibration,
                                @RequestParam(defaultValue = "false") boolean Microclimate,
                                @RequestParam(defaultValue = "false") boolean Illumination,
                                @RequestParam(defaultValue = "false") boolean LaserRadiation,
                                @RequestParam(defaultValue = "false") boolean Aeroions,
                                @RequestParam(defaultValue = "false") boolean Ultrasound,
                                @RequestParam(defaultValue = "false") boolean Infrasound,
                                @RequestParam(defaultValue = "false") boolean VCH,
                                @RequestParam(defaultValue = "false") boolean VDT,
                                @RequestParam(defaultValue = "false") boolean SVCH,
                                @RequestParam(defaultValue = "false") boolean m50Hg,
                                @RequestParam(defaultValue = "false") boolean PMP
    ) throws IOException {

        Request request = requestService.findByNumber(objective.getRequest().getNumber());
        for (Request r : requestService.findAll()) {
            if (r.getNumber().equals(number.toString()) && r != request)
                return "objective_edit";
        }

        request.setNumber(number.toString());
        request.setTypeCustomer(typeCustomer);
        request.setNameCustomer(nameCustomer);
        request.setAddressCustomer(addressCustomer);
        if (UploadUtils.uploadFile(UPLOAD_PATH_REQUESTS_FILES, file)) {
            request.setFilename(file.getOriginalFilename());
        }
        requestService.save(request);

        objective.setDistrictWork(districtWork);
        objective.setCityWork(cityWork);
        objective.setStreetWork(streetWork);
        objective.setHouseWork(houseWork);
        objective.setAddressWork();
        objective.setResponsible(responsible);
        objective.setExecutor(executor);
        objectiveService.setCorrectDate(objective, deadline);
        objective.setTypeOfPayment(typeOfPayment);

        objective.setProjectRTO(ProjectRTO);
        objective.setCommissioningRTO(CommissioningRTO);
        objective.setIff(IFF);
        objective.setResearchResults(ResearchResults);

        objective.setNoise(Noise);
        objective.setVibration(Vibration);
        objective.setMicroclimate(Microclimate);
        objective.setIllumination(Illumination);
        objective.setLaserRadiation(LaserRadiation);
        objective.setAeroions(Aeroions);
        objective.setUltrasound(Ultrasound);
        objective.setInfrasound(Infrasound);
        objective.setVch(VCH);
        objective.setVdt(VDT);
        objective.setSvch(SVCH);
        objective.setM50Hg(m50Hg);
        objective.setPmp(PMP);

        objectiveService.save(objective, request);
        objectiveService.saveMeasuresByObjective(objective);
        return "redirect:/";

    }



    /*//converter
            //Добавить doc конвертор
            InputStream in = new FileInputStream(new File(resultFileName));
            XWPFDocument document = new XWPFDocument(in);
            XHTMLOptions options = XHTMLOptions.create();
            File packetHtml = new File(uploadPathHtml);
            if (!packetHtml.exists()) {
                packetHtml.mkdir();
            }
            String htmlNameFile = file.getOriginalFilename().split("\\.")[0] + ".html";
            File htmlFile = new File(packetHtml + "/" + htmlNameFile);

            OutputStream out = new FileOutputStream(htmlFile);
            XHTMLConverter.getInstance().convert(document, out, options);
            request.setFilenameHtml(htmlNameFile);*/
}
