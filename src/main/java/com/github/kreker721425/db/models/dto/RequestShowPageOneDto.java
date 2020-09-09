package com.github.kreker721425.db.models.dto;

import com.github.kreker721425.db.models.Objective;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class RequestShowPageOneDto {
    private Long id;
    private long number;                 //№ заявки
    private String typeCustomer;        //Вид заказчика
    private String nameCustomer;        //Наименование заказчика
    private String addressCustomer;     //Адрес заказчика
    private String typeOwner;           //Вид
    private String nameOwner;           //Наименование
    private String addressOwner;        //Адрес
    private List<ObjectiveDto> objectives;
}
