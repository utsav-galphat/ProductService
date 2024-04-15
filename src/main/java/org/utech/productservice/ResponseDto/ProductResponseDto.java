package org.utech.productservice.ResponseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class ProductResponseDto {
    private UUID id;
    private String title;
    private String description;
    private Long price;
    private CategoryResponseDto category;
}
