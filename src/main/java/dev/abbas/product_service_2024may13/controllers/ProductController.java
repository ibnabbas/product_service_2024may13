package dev.abbas.product_service_2024may13.controllers;

import dev.abbas.product_service_2024may13.dto.ProductResponseDto;
import dev.abbas.product_service_2024may13.models.Product;
import dev.abbas.product_service_2024may13.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public ProductResponseDto getProductDetails(@PathVariable("id") int productId ) {
        Product product = productService.getSingleProduct(productId);
        return convertToProductResponseDto(product);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product : products) {
            productResponseDtos.add(convertToProductResponseDto(product));
        }
        return productResponseDtos;
    }

    @PostMapping("/products")
    public ProductResponseDto createNewProduct(@RequestBody ProductResponseDto productRequestDto ) {
        Product product = productService.addProduct(
              productRequestDto.getTitle(),
              productRequestDto.getDescription(),
              productRequestDto.getImage(),
              productRequestDto.getCategory(),
              productRequestDto.getPrice()
        );
        return convertToProductResponseDto(product);
    }

    private ProductResponseDto convertToProductResponseDto(Product product) {
        String categoryTitle = product.getCategory().getTitleOfCategory();
        ProductResponseDto productResponseDto = modelMapper.map(product, ProductResponseDto.class);
        productResponseDto.setCategory(categoryTitle);
        return productResponseDto;
    }

}
