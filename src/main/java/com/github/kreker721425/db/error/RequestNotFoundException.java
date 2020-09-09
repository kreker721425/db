package com.github.kreker721425.db.error;

public class RequestNotFoundException extends RuntimeException{
    public RequestNotFoundException() {
        super("Заявка не найдена");
    }
}
