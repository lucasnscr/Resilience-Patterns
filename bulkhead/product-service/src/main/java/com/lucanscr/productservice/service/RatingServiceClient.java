package com.lucanscr.productservice.service;

import com.lucanscr.dto.ProductRatingDto;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RatingServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${rating.service.endpoint}")
    private String ratingService;

    @Bulkhead(name = "ratingService", fallbackMethod = "getDefault")
    public ProductRatingDto getProductRatingDto(int productId){
        ProductRatingDto productRatingDtoResponseEntityBody = null;
        ResponseEntity<ProductRatingDto> productRatingDtoResponseEntity = this.restTemplate.getForEntity(this.ratingService + productId, ProductRatingDto.class);
        if (productRatingDtoResponseEntity.getStatusCode().is2xxSuccessful()){
            productRatingDtoResponseEntityBody = productRatingDtoResponseEntity.getBody();
        }
        return productRatingDtoResponseEntityBody;
    }

    public ProductRatingDto getDefault(int productId, Throwable throwable){
        return ProductRatingDto.of(0, Collections.emptyList());
    }



}
