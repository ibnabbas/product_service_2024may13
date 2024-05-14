package dev.abbas.product_service_2024may13.controllers;

import dev.abbas.product_service_2024may13.dto.ProductResponseDto;
import dev.abbas.product_service_2024may13.models.Product;
import dev.abbas.product_service_2024may13.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;
    private ModelMapper modelMapper;

    public ProductController(ProductService productService,
                             ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/hello")
    public String helloWorld() {

        return "Hello World!!";
    }
    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") int productId ) {
        return productService.getSingleProduct(productId);
        //return null;
    }
    @PostMapping("/products")
    public Product createNewProduct(@RequestBody ProductResponseDto productRequestDto ) {
        return productService.addProduct(
              productRequestDto.getTitle(),
              productRequestDto.getDescription(),
              productRequestDto.getImage(),
              productRequestDto.getCategory(),
              productRequestDto.getPrice()
        );
    }

}
