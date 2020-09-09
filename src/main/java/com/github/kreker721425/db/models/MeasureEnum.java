package com.github.kreker721425.db.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MeasureEnum {
    Noise("Шум"),
    Vibration("Вибрация"),
    Microclimate("Микроклимат"),
    Illumination("Иллюминация");

    private final String title;
}
