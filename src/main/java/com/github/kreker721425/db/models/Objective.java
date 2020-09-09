package com.github.kreker721425.db.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "objective")
public class Objective {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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
    //Объект надзора
    //Кто платит (план/договор)
    //Рабочие места - количество
    //Рабочие места - не соответствуют
    //Измерения - количество
    //Измерения - не соответствуют


    //измерения ОИ
    private int expertiseProjectRTO;        //экспертиза проекта по РТО
    private int expertiseCommissioningRTO;  //экспертиза ввод в эксплуатацию по РТО
    private int expertiseIFF;               //экспертиза на условия работ с ИФФ
    private int expertiseResearchResults;   //экспертиза по результатам проведенных исследований

    //измерения ИЛЦ
    private int measurementsNoise;          //шум
    private int measurementsVibration;      //вибрация
    private int measurementsMicroclimate;   //микроклимат
    private int measurementsIllumination;   //освещенность
    private int measurementsLaserRadiation; //лазерное излучение
    private int measurementsAeroions;       //аэроионы
    private int measurementsUltrasound;     //ультразвук
    private int measurementsInfrasound;     //инфразвук
    private int measurementsVCH;            //ЭМП ВЧ
    private int measurementsVDT;            //ЭМП ВДТ
    private int measurementsSVCH;           //ЭМП СВЧ
    private int measurements50Hg;           //ЭМП 50гц
    private int measurementsPMP;            //ПМП


    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;
}
