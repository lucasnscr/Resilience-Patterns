package com.lucasnscr.resilience.ratelimiter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
public class Response {

    private int input;
    private long output;
    private ResponseType responseType;
    private String message;

}
