package org.egorov.model;

import org.egorov.dto.GoodDto;
import org.egorov.dto.GoodLocalDto;

import java.time.LocalDateTime;

public class Mapper {
//    /**
//     * Good to GoodLocal
//     */
//    public static GoodDto toGoodLocal(Good good) {
//        return GoodLocal.builder()
//                .goodId(good.getId())
//                .placeId(good.)
//                .dateTime(LocalDateTime.now().withNano(0))
//                .beep(false)
//                .build();
//    }

    /**
     * make GoodLocal
     */
    public static GoodLocal makeGoodLocalDto(Long goodId, Long placeId) {
        return GoodLocal.builder()
                .goodId(goodId)
                .placeId(placeId)
                .dateTime(LocalDateTime.now().withNano(0))
                .beep(false)
                .build();
    }

    /**
     * GoodLocal to GoodLocalDto
     */
    public static GoodLocalDto toGoodLocalDto(GoodLocal goodLocal) {
        return GoodLocalDto.builder()
                .id(goodLocal.getId())
                .goodId(goodLocal.getGoodId())
                .placeId(goodLocal.getPlaceId())
                .dateTime(goodLocal.getDateTime())
                .build();
    }

//    /**
//     * GoodLocal to Good
//     */
//    public static GoodDto toGood(GoodLocal goodLocal) {
//        return Good.builder()
//                .name(goodLocal.getName())
//                .category(goodLocal.getCategory())
//                .price(goodLocal.getPrice())
//                .build();
//    }
}
