package com.github.kreker721425.db.controllers;

import com.github.kreker721425.db.constants.ServicesConstants;
import com.github.kreker721425.db.models.Objective;
import com.github.kreker721425.db.models.Request;
import com.github.kreker721425.db.models.dto.InitialData;
import com.github.kreker721425.db.services.InitialDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class TableController {

    @Autowired
    private InitialDataService initialDataService;

    @Value("${upload.path.word}")
    private String uploadPathWord;

    @GetMapping("/")
    public String start() {
        return "greeting";
    }

    @GetMapping("table")
    public String table(@RequestParam(required = false, defaultValue = "") String filterNumber,
                        Model model){
        List<InitialData> list = initialDataService.findAll();
        if (filterNumber != null && !filterNumber.isEmpty()) {
            list = initialDataService.findByNumber(Integer.parseInt(filterNumber));
        }
        model.addAttribute("list",list);
        model.addAttribute("filterNumber", filterNumber);

        return "table";
    }

    /*@PostMapping("table")
    public String choose(@RequestParam Map<String, String> form,
                         @RequestParam(value = "choose", required = false) String choose,
                         Model model
    ){
        Set<String> setId = new HashSet<>();
        for (BigInteger id: requestRepository.findAllId()) {
            setId.add(id.toString());
        }
        String s;
        for (String key: form.keySet()){
            if (setId.contains(key)) {
                s = key;
                requestRepository.save(new Request(1,s));
            }
        }
        model.addAttribute("choose",choose);
        return "table";
    }*/

    @GetMapping("addRequest")
    public String addShow(){
        return "addRequest";
    }


    @PostMapping("addRequest")
    public String add(@Valid Request request,
                      @Valid Objective objective,
                      @RequestParam(value = "expertiseProjectRTO", required = false) String expertiseProjectRTO,
                      @RequestParam(value = "expertiseCommissioningRTO", required = false) String expertiseCommissioningRTO,
                      @RequestParam(value = "expertiseIFF", required = false) String expertiseIFF,
                      @RequestParam(value = "expertiseResearchResults", required = false) String expertiseResearchResults,

                      @RequestParam(value = "measurementsNoise", required = false) String measurementsNoise,
                      @RequestParam(value = "measurementsVibration", required = false) String measurementsVibration,
                      @RequestParam(value = "measurementsMicroclimate", required = false) String measurementsMicroclimate,
                      @RequestParam(value = "measurementsIllumination", required = false) String measurementsIllumination,
                      @RequestParam(value = "measurementsLaserRadiation", required = false) String measurementsLaserRadiation,
                      @RequestParam(value = "measurementsAeroions", required = false) String measurementsAeroions,
                      @RequestParam(value = "measurementsUltrasound", required = false) String measurementsUltrasound,
                      @RequestParam(value = "measurementsInfrasound", required = false) String measurementsInfrasound,
                      @RequestParam(value = "measurementsVCH", required = false) String measurementsVCH,
                      @RequestParam(value = "measurementsVDT", required = false) String measurementsVDT,
                      @RequestParam(value = "measurementsSVCH", required = false) String measurementsSVCH,
                      @RequestParam(value = "measurements50Hg", required = false) String measurements50Hg,
                      @RequestParam(value = "measurementsPMP", required = false) String measurementsPMP,
                      @RequestParam("file") MultipartFile file,
                      BindingResult bindingResult,
                      Model model
    ) throws IOException {

        if (expertiseProjectRTO!=null) objective.setIlcService(objective.getIlcService()+ServicesConstants.EXPERTISE_PROJECT_RTO+"\n");
        if (expertiseCommissioningRTO!=null) objective.setIlcService(objective.getIlcService()+ServicesConstants.EXPERTISE_COMMISSIONING_RTO+"\n");
        if (expertiseIFF!=null) objective.setIlcService(objective.getIlcService()+ServicesConstants.EXPERTISE_IFF+"\n");
        if (expertiseResearchResults!=null) objective.setIlcService(objective.getIlcService()+ServicesConstants.EXPERTISE_RESEARCH_RESULTS+"\n");

        if (objective.getIlcService().isEmpty()) objective.setIlcService(objective.getIlcService()+"НЕТ");

        if (measurementsNoise!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_NOISE+"\n");
        if (measurementsVibration!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_VIBRATION+"\n");
        if (measurementsMicroclimate!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_MICROCLIMATE+"\n");
        if (measurementsIllumination!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_ILLUMINATION+"\n");
        if (measurementsLaserRadiation!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_LASER_RADIATION+"\n");
        if (measurementsAeroions!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_AEROIONS+"\n");
        if (measurementsUltrasound!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_ULTRASOUND+"\n");
        if (measurementsInfrasound!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_INFRASOUND+"\n");
        if (measurementsVCH!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_VCH+"\n");
        if (measurementsVDT!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_VDT+"\n");
        if (measurementsSVCH!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_SVCH+"\n");
        if (measurements50Hg!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_50HG+"\n");
        if (measurementsPMP!=null) objective.setOiService(objective.getOiService()+ServicesConstants.MEASUREMENTS_PMP+"\n");

        if (objective.getOiService().isEmpty()) objective.setOiService(objective.getOiService()+"НЕТ");


        /*if (bindingResult.hasErrors()) {
            Collector<FieldError,?, Map<String, String>> collector = Collectors.toMap(
                    fieldError -> fieldError.getField() + "Error",
                    FieldError::getDefaultMessage
            );
            Map<String ,String> errorsMap = bindingResult.getFieldErrors().stream().collect(collector);
            model.mergeAttributes(errorsMap);
            model.addAttribute("request",request);
            return "addRequest";
        }*/

        if (file != null && !file.isEmpty()) {
            File uploadFile = new File(uploadPathWord);
            if (!uploadFile.exists()) {
                uploadFile.mkdir();
            }

            //Присваивание шифра
            /*String uuid = UUID.randomUUID().toString();
            String resultFileName = uuid + "." + file.getOriginalFilename();*/
            String resultFileName = uploadFile + "/" + file.getOriginalFilename();

            file.transferTo(new File(resultFileName));
            request.setFilename(file.getOriginalFilename());
        }
        ArrayList<Objective> objectives = new ArrayList<>();
        objectives.add(objective);
        initialDataService.save(new InitialData(request,objectives));
        return "redirect:/table";
    }

    @GetMapping("measurementsAdd")
    public String measurementsAddShow(){
        return "measurementsAdd";
    }


    @PostMapping("measurementsAdd")
    public String measurementsAdd(@Valid Request request,
                      @RequestParam("file") MultipartFile file,
                      BindingResult bindingResult,
                      Model model
    ) throws IOException {
        /*if (bindingResult.hasErrors()) {
            Collector<FieldError,?, Map<String, String>> collector = Collectors.toMap(
                    fieldError -> fieldError.getField() + "Error",
                    FieldError::getDefaultMessage
            );
            Map<String ,String> errorsMap = bindingResult.getFieldErrors().stream().collect(collector);
            model.mergeAttributes(errorsMap);
            model.addAttribute("request",request);
            return "addRequest";
        }*/

        /*if (request.getOiService() != null) request.setOiService("Да");
        else request.setOiService("Нет");
        if (request.getIlcService() != null) request.setIlcService("Да");
        else request.setIlcService("Нет");

        if (file != null && !file.isEmpty()) {
            File uploadFile = new File(uploadPathWord);
            if (!uploadFile.exists()) {
                uploadFile.mkdir();
            }

            //Присваивание шифра
            *//*String uuid = UUID.randomUUID().toString();
            String resultFileName = uuid + "." + file.getOriginalFilename();*//*
            String resultFileName = uploadFile + "/" + file.getOriginalFilename();

            file.transferTo(new File(resultFileName));
            request.setFilenameDoc(file.getOriginalFilename());
        }

        requestRepository.save(request);*/
        return "redirect:/table";
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
