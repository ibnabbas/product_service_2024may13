package dev.abbas.product_service_2024may13.services;

import dev.abbas.product_service_2024may13.dto.FakeStoreDto;
import dev.abbas.product_service_2024may13.dto.ProductResponseDto;
import dev.abbas.product_service_2024may13.models.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
    //public Product createProduct(Product product);
    public Product getSingleProduct(int productId);

    public Product addProduct(
            String title,
            String description,
            String imageUrl,
            String category,
            double price
    );

}


