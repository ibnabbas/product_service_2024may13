package dev.abbas.product_service_2024may13.dto;

import dev.abbas.product_service_2024may13.models.Category;
import dev.abbas.product_service_2024may13.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {
    private int id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;

    public Product toProduct() {

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Category categoryObj = new Category();
        categoryObj.setTitleOfCategory(category);
        product.setCategory(categoryObj);
        return  product;
    }
}
