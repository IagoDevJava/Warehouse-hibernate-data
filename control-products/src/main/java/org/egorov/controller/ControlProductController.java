package org.egorov.controller;

import lombok.AllArgsConstructor;
import org.egorov.dto.GoodLocalDto;
import org.egorov.model.GoodLocal;
import org.egorov.service.ControlProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/control-products")
public class ControlProductController {
    private final ControlProductService service;

    /**
     * Добавление товара при покупке
     */
    @PostMapping("/{productId}")
    public GoodLocalDto addGood(@PathVariable Long productId, @RequestParam Long placeId) {
        return service.addGood(productId, placeId);
    }

    /**
     * Удаление товара когда он закончился
     */
    @DeleteMapping("/{productId}")
    public void deleteGood(@PathVariable Long productId) {
        service.deleteGood(productId);
    }

    /**
     * Получение сигнала сколько лежит товар (true - > 14 дней,  false - < 14 дней)
     */
    @DeleteMapping("/beep")
    public Boolean getBeep(@Valid @RequestBody GoodLocal goodLocal) {
        return service.getBeep(goodLocal);
    }
}
