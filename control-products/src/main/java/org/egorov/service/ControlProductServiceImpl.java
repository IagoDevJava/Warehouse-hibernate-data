package org.egorov.service;

import lombok.AllArgsConstructor;
import org.egorov.dto.GoodLocalDto;
import org.egorov.model.GoodLocal;
import org.egorov.model.Mapper;
import org.egorov.repository.GoodLocalRepository;
import org.egorov.repository.GoodRepository;
import org.egorov.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ControlProductServiceImpl implements ControlProductService {
    private final GoodLocalRepository localRepository;
    private final PlaceRepository placeRepository;
    private final GoodRepository repository;

    /**
     * Добавление товара при покупке
     */
    @Override
    public GoodLocalDto addGood(Long productId, Long placeId) {
        //TODO сделать эти проверки на входе
//        placeRepository.findById(placeId).orElseThrow(() -> new PlaceNotFoundException("Place not found"));
//        if (repository.findById(productId).isEmpty()) {
//        }
//        Good good = repository
//                .findById(productId).orElseThrow(() -> new GoodNotFoundException("Good not found in database"));
        GoodLocal goodLocal = Mapper.makeGoodLocalDto(productId, placeId);
        GoodLocal save = localRepository.save(goodLocal);

        return Mapper.toGoodLocalDto(save);
    }

    /**
     * Удаление товара когда он закончился
     */
    @Override
    public void deleteGood(Long productId) {
        localRepository.deleteById(productId);
    }

    /**
     * Напомнить, что товар долго лежит
     */
    @Override
    public Boolean getBeep(GoodLocal goodLocal) {
        LocalDateTime dateTimePurchase = goodLocal.getDateTime();
        Long categoryId = repository.findCategoryId(goodLocal.getGoodId());
        Integer expirationDate = repository.findExpirationDate(categoryId, goodLocal.getPlaceId());
        if (dateTimePurchase.plusDays(expirationDate).equals(LocalDateTime.now().withNano(0))) {
            goodLocal.setBeep(true);
        }
        return goodLocal.getBeep();
    }
}
