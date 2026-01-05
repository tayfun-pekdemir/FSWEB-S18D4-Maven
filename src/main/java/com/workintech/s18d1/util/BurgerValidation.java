package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void validateBurger(Burger burger) {
        if (burger.getName() == null || burger.getName().isBlank()) {
            throw new BurgerException("Burger name cannot be empty", HttpStatus.BAD_REQUEST);
        }
        if (burger.getPrice() <0) {
            throw new BurgerException("Burger price must be greater than 0", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validateId(long id) {
        if (id < 0) {
            throw new BurgerException("Id must be greater than 0", HttpStatus.BAD_REQUEST);
        }
    }

    public static void validatePrice(double price) {
        if (price < 0) {
            throw new BurgerException("Price must be positive", HttpStatus.BAD_REQUEST);
        }
    }
    public static void validateBreadType(BreadType breadType) {
        if (breadType == null) {
            throw new BurgerException("Bread type must be specified", HttpStatus.BAD_REQUEST);
        }
    }
    public static void validateContent(String content) {
        if (content == null || content.isBlank()) {
            throw new BurgerException("Content cannot be empty", HttpStatus.BAD_REQUEST);
        }
    }
}