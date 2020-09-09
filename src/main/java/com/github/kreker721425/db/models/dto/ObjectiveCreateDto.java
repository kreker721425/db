package com.github.kreker721425.db.models.dto;

import com.github.kreker721425.db.models.MeasureEnum;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ObjectiveCreateDto {
    private String oiService;         //ОИ
    private List<MeasureEnum> ilcService;        //ИЛЦ

    //Место проведения работ
    //@NotBlank(message = "Введите регион работ")
    private String districtWork;            //Район
    //    @NotBlank(message = "Введите город работ")
    private String cityWork;                //Город
    //    @NotBlank(message = "Введите улицу работ")
    private String streetWork;              //Улица
    //    @NotBlank(message = "Введите дом работ")
    private String houseWork;               //Дом


    //    @NotBlank(message = "Выберите ответственного")
    private String responsible;         //Ответственный
    private String executor;            //Исполнитель
    private Date deadline;              //Срок выполнения
    private boolean status;             //Статус
    private Date dateCompleted;         //Дата сдачи*/


    // !!!!!!!!!!
    private Long requestId;
}
