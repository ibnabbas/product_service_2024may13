package dev.abbas.product_service_2024may13.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private Category category;
}
