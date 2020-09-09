package com.github.kreker721425.db.models.dto;

public class RequestCreateDto {
    private long number;                 //№ заявки

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
}
