package com.lucasnscr.resilience.ratelimiter.controller;

import com.lucasnscr.resilience.ratelimiter.dto.Response;
import com.lucasnscr.resilience.ratelimiter.dto.ResponseType;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimiterController {

    @GetMapping("/double/{input}")
    public Response doubleValue(@PathVariable int input){
        return Response.of(input, 2*input, ResponseType.SUCCESS, Strings.EMPTY);
    }

    @GetMapping("/square/{input}")
    @RateLimiter(name = "squareLimit", fallbackMethod = "squareErrorResponse")
    public Response getValue(@PathVariable int input){
        return Response.of(input, input * input, ResponseType.SUCCESS, Strings.EMPTY);
    }

    public Response squareErrorResponse(int input, Throwable throwable){
        return Response.of(input, -1, ResponseType.FAILURE, throwable.getMessage());
    }

}
