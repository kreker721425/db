package com.github.kreker721425.db.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class ObjectiveDto {
    private Long id;

    private String oiService;         //ОИ
    private String ilcService;        //ИЛЦ

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
}
