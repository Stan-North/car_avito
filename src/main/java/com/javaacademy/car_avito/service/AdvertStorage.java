package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.advert.Advert;
import com.javaacademy.car_avito.advert.Brand;
import com.javaacademy.car_avito.advert.Color;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class AdvertStorage {
    private final Map<Integer, Advert> data = new HashMap<>();
    private int counter = 0;

    public void save(Advert advert) {
        counter++;
        advert.setId(counter);
        data.put(counter, advert);
    }

    public Optional<Advert> getById(Integer id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Advert> getAll() {
        return data.values().stream().toList();
    }

    public boolean delete(Integer id) {
        return data.remove(id) != null;
    }

    public List<Advert> getByParams(Brand brand, Color color, BigDecimal price) {
        List<Advert> temp = data.values().stream().toList();
        if (brand != null) {
            temp = filterByBrand(brand, temp);
        }
        if (color != null) {
            temp = filterByColor(color, temp);
        }
        if (price != null) {
            temp = filterByPrice(price, temp);
            }
        return temp;
    }

    private List<Advert> filterByBrand(Brand brand, List<Advert> adverts) {
        return adverts.stream()
                .filter(advert -> Objects.equals(brand, advert.getBrand()))
                .toList();
    }

    private List<Advert> filterByColor(Color color, List<Advert> adverts) {
        return adverts.stream()
                .filter(advert -> Objects.equals(color, advert.getColor()))
                .toList();
    }

    private List<Advert> filterByPrice(BigDecimal price, List<Advert> adverts) {
        return adverts.stream()
                .filter(advert -> Objects.equals(price, advert.getPrice()))
                .toList();
    }
}
