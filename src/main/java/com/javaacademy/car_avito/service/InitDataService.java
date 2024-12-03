package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.advert.Advert;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
@Profile("test")
public class InitDataService {
    private static final BigDecimal FIRST_PRICE = BigDecimal.valueOf(10_000);
    private static final BigDecimal SECOND_PRICE = BigDecimal.valueOf(15_000);
    private AdvertStorage advertStorage;

    @PostConstruct
    public void init() {
        Advert advert1 = create("Audi", "black", FIRST_PRICE);
        Advert advert2 = create("Audi", "white", FIRST_PRICE);
        Advert advert3 = create("BMW", "black", SECOND_PRICE);
        Advert advert4 = create("Volvo", "black", SECOND_PRICE);
        advertStorage.save(advert1);
        advertStorage.save(advert2);
        advertStorage.save(advert3);
        advertStorage.save(advert4);
    }

    private Advert create(String brand, String color, BigDecimal price) {
        return Advert.builder()
                .brand(brand)
                .color(color)
                .price(price)
                .build();
    }

}
