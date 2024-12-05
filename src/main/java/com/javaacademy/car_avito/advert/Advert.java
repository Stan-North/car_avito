package com.javaacademy.car_avito.advert;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Advert {
    private Integer id;
    private String brand;
    private String color;
    private BigDecimal price;
}
