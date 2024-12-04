package com.javaacademy.car_avito.advert;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Brand {
    AUDI("Audi"),
    BMW("Bmw");

    private final String title;
}
