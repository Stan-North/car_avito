package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.advert.Advert;
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

    public List<Advert> getByParams(String brand, String color, BigDecimal price) {
        List<Advert> temp = data.values().stream().toList();
        temp = filterByBrand(brand, temp);
        temp = filterByColor(color, temp);
        temp = filterByPrice(price, temp);
        return temp;
    }

    private List<Advert> filterByBrand(String brand, List<Advert> adverts) {
        if ("null".equals(brand)) {
            return adverts.stream()
                    .filter(advert -> advert.getBrand() == null)
                    .toList();
        } else if (brand != null) {
            return adverts.stream()
                    .filter(advert -> Objects.equals(brand, advert.getBrand()))
                    .toList();
        }
        return adverts;
    }


    private List<Advert> filterByColor(String color, List<Advert> adverts) {
        if ("null".equals(color)) {
            return adverts.stream()
                    .filter(advert -> advert.getColor() == null)
                    .toList();
        } else if (color != null) {
            return adverts.stream()
                    .filter(advert -> Objects.equals(color, advert.getColor()))
                    .toList();
        }
        return adverts;
    }


    private List<Advert> filterByPrice(BigDecimal price, List<Advert> adverts) {
        if ("null".equals(price)) {
            return adverts.stream()
                    .filter(advert -> advert.getPrice() == null)
                    .toList();
        } else if (price != null) {
            return adverts.stream()
                    .filter(advert -> Objects.equals(price, advert.getPrice()))
                    .toList();
        }
        return adverts;
    }
}
