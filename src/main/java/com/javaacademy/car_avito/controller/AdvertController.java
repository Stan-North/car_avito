package com.javaacademy.car_avito.controller;

import com.javaacademy.car_avito.advert.Advert;
import com.javaacademy.car_avito.service.AdvertStorage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdvertController {
    private final AdvertStorage advertStorage;

    @PostMapping("/advert")
    public void saveAdvert(@RequestBody Advert advert) {
        log.info(advert.toString());
        advertStorage.save(advert);
    }

    @GetMapping("/advert/brand/{brand}")
    public List<Advert> getAllByBrand(@PathVariable String brand) {
       return advertStorage.getAll()
               .stream()
               .filter(advert -> Objects.equals(advert.getBrand(), brand))
               .toList();
    }

    @DeleteMapping("/advert/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        return advertStorage.delete(id);
    }

    @GetMapping("/advert/{id}")
    public Advert getById(@PathVariable Integer id) {
        log.info(id.toString() + advertStorage.toString());
        return advertStorage.getById(id).orElseThrow();
    }

}
