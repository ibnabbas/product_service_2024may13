package dev.abbas.product_service_2024may13.controllers;

import dev.abbas.product_service_2024may13.dto.ProductResponseDto;
import dev.abbas.product_service_2024may13.models.Product;
import dev.abbas.product_service_2024may13.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/products/{id}")
    public ProductResponseDto getProductDetails(@PathVariable("id") int productId ) {
        //return productService.getSingleProduct(productId);
        return null;
    }

}
