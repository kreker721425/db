package com.github.kreker721425.db.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//https://devcolibri.com/как-сохранить-enum-в-бд-используя-jpa/

@Data
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

//    @NotBlank(message = "Введите номер заявки")
@Column(name = "number")
private String number;                 //№ заявки

//    @NotBlank(message = "Выберите тип заказчика")
    private String typeCustomer;        //Вид заказчика
//    @NotBlank(message = "Введите наименование заказчика")
    private String nameCustomer;        //Наименование заказчика
//    @NotBlank(message = "Введите адрес заказчика")
    private String addressCustomer;     //Адрес заказчика

    //Владелец
//    @NotBlank(message = "Выберите тип владельца")
    private String typeOwner;           //Вид
    //    @NotBlank(message = "Введите наименование владельца")
    private String nameOwner;           //Наименование
    //    @NotBlank(message = "Введите адрес владельца")
    private String addressOwner;        //Адрес


    //    @NotBlank(message = "Выберите файл заявки")
    private String filename;


    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Objective> objectives;

    public Request() {
    }
}

