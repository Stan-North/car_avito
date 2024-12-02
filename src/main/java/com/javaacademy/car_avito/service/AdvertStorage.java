package com.javaacademy.car_avito.service;

import com.javaacademy.car_avito.advert.Advert;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
}
