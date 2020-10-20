package com.github.kreker721425.db.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "objective")
public class Objective {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String fileMeasure;

    //Место проведения работ
    private String addressWork;
    private String districtWork;            //Район
    private String cityWork;                //Город
    private String streetWork;              //Улица
    private String houseWork;               //Дом


    private String responsible;         //Ответственный
    private String executor;            //Исполнитель
    private String deadline;              //Срок выполнения
    private boolean status;             //Статус
    private String dateCompleted;         //Дата сдачи*/
    //Объект надзора

    private String typeOfPayment;       //Кто платит (план/договор)
    private int workPlaces;             //Рабочие места - количество
    private int workPlacesNo;           //Рабочие места - не соответствуют
    private int measurement;            //Измерения - количество
    private int measurementNo;          //Измерения - не соответствуют


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

    //ОИ логические
    private boolean oi;
    private boolean projectRTO;        //экспертиза проекта по РТО
    private boolean commissioningRTO;  //экспертиза ввод в эксплуатацию по РТО
    private boolean iff;               //экспертиза на условия работ с ИФФ
    private boolean researchResults;   //экспертиза по результатам проведенных исследований

    //ИЛЦ логические
    private boolean ilc;
    private boolean noise;          //шум
    private boolean vibration;      //вибрация
    private boolean microclimate;   //микроклимат
    private boolean illumination;   //освещенность
    private boolean laserRadiation; //лазерное излучение
    private boolean aeroions;       //аэроионы
    private boolean ultrasound;     //ультразвук
    private boolean infrasound;     //инфразвук
    private boolean vch;            //ЭМП ВЧ
    private boolean vdt;            //ЭМП ВДТ
    private boolean svch;           //ЭМП СВЧ
    private boolean m50Hg;           //ЭМП 50гц
    private boolean pmp;            //ПМП


    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OI> measuresOI;

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ILC> measuresILC;

    public void setAddressWork() {
        this.addressWork = this.districtWork + " район, " + this.cityWork + ", " + this.streetWork + ", " + this.houseWork;
    }
}
