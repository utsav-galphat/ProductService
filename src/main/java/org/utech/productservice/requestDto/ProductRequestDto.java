package org.utech.productservice.requestDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class ProductRequestDto {
    private UUID id;
    private String description;
    private Long price;
    private String title;
    private CategoryRequestDto category;
}
