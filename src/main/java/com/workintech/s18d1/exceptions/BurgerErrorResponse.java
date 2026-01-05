package com.workintech.s18d1.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BurgerErrorResponse {

    private String message;


    public BurgerErrorResponse(String message) {

        this.message = message;

    }

}
