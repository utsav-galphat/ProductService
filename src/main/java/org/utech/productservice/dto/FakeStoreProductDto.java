package org.utech.productservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FakeStoreProductDto {

    private UUID id;
    private String title;
    private String description;
    private Long price;
    private String category;
}
