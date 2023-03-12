package org.egorov.service;

import org.egorov.dto.GoodLocalDto;
import org.egorov.model.GoodLocal;

public interface ControlProductService {
    /**
     * Добавление товара при покупке
     */
    GoodLocalDto addGood(Long productId, Long placeId);

    /**
     * Удаление товара когда он закончился
     */
    void deleteGood(Long productId);

    /**
     * Напомнить, что товар долго лежит
     */
    Boolean getBeep(GoodLocal goodLocal);
}
