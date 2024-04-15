package org.utech.productservice.requestDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class CategoryRequestDto {
    private UUID id;
    private String title;
}
