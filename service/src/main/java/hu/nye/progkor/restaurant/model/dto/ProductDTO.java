package hu.nye.progkor.restaurant.model.dto;

import hu.nye.progkor.restaurant.model.FoodType;

public record ProductDTO(Long id, String name, Integer valueOfNormal, Integer valueOfBig, FoodType foodType, String description) {
}
