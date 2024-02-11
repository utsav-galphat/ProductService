package org.utech.productservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.utech.productservice.models.Category;

@Getter
@Setter
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String description;
    private Long price;
    private String category;
}
