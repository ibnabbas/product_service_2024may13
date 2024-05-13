package dev.abbas.product_service_2024may13.services;

import dev.abbas.product_service_2024may13.dto.FakeStoreDto;
import dev.abbas.product_service_2024may13.dto.ProductResponseDto;
import dev.abbas.product_service_2024may13.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public ProductResponseDto getSingleProduct(int productId) {

        FakeStoreDto fakeStoreDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products" + productId,
                FakeStoreDto.class
        );

        return fakeStoreDto.toProductResponseDto();
    }
}
