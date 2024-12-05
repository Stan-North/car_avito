package com.javaacademy.car_avito.controller;

import com.javaacademy.car_avito.advert.Advert;
import com.javaacademy.car_avito.service.AdvertStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/adverts")
public class AdvertController {
    private final AdvertStorage advertStorage;

    @PostMapping()
    public void saveAdvert(@RequestBody Advert advert) {
        advertStorage.save(advert);
    }

    @GetMapping("/brands/{brand}")
    public List<Advert> getAllByBrand(@PathVariable String brand) {
       return advertStorage.getAll()
               .stream()
               .filter(advert -> Objects.equals(advert.getBrand(), brand))
               .toList();
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Integer id) {
        return advertStorage.delete(id);
    }

    @GetMapping("/{id}")
    public Advert getById(@PathVariable Integer id) {
        return advertStorage.getById(id).orElseThrow();
    }

    @GetMapping("/search")
    public List<Advert> getByParams(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) BigDecimal price) {
        return advertStorage.getByParams(brand, color, price);
    }
}
