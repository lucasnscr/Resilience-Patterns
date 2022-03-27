package com.lucanscr.rattingservice.service;

import com.lucanscr.dto.ProductRatingDto;
import com.lucanscr.dto.ReviewDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Service
public class RatingService {

    private Map<Integer, ProductRatingDto> map;

    @PostConstruct
    private void init(){

        ProductRatingDto ratingDto1 = ProductRatingDto.of(4.5,
                List.of(
                        ReviewDto.of("Apple", "AirPods", 1, 5, "excellent"),
                        ReviewDto.of("Apple", "iPad", 1, 4, "good")
                )
        );

        ProductRatingDto ratingDto2 = ProductRatingDto.of(4,
                List.of(
                        ReviewDto.of("Apple", "Tv", 2, 5, "best"),
                        ReviewDto.of("Apple", "Watch", 2, 3, "great")
                )
        );

        this.map = Map.of(
                1, ratingDto1,
                2, ratingDto2
        );

    }

    public ProductRatingDto getRatingForProduct(int productId) {
        return this.map.getOrDefault(productId, new ProductRatingDto());
    }

}
