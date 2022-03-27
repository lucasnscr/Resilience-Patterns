package com.lucanscr.productservice.service;

import com.lucanscr.dto.ProductDto;
import com.lucanscr.dto.ProductRatingDto;
import com.lucanscr.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private Map<Integer, Product> productMap;

    @Autowired
    private RatingServiceClient ratingServiceClient;

    @PostConstruct
    private void init(){
        this.productMap = Map.of(
                1, Product.of(1, "Macbook Pro", 1900.00),
                2, Product.of(2, "iPhone 13 Pro", 999.00)
                );
    }

    public CompletionStage<ProductDto> getProductDto(int productId){
        return this.ratingServiceClient.getProductRatingDto(1)
                .thenApply(productRatingDto -> {
                    Product product = this.productMap.get(productId);
                    return ProductDto.of(productId, product.getDescription(), product.getPrice(), productRatingDto);
                });
    }



}
