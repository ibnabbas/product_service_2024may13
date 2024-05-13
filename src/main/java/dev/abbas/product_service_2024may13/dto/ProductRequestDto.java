package dev.abbas.product_service_2024may13.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private int id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;
}
