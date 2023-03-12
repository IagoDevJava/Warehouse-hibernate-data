package org.egorov.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoodDto {
    Long id;
    String name;
    String category;
    Double price;
}
