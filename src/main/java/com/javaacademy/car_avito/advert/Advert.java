package com.javaacademy.car_avito.advert;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Advert {
    private Integer id;
    private Brand brand;
    private Color color;
    private BigDecimal price;
}
