package hu.nye.progkor.restaurant.model.response;

import hu.nye.progkor.restaurant.model.FoodType;

public record ProductResponse(Long id, String name, Integer valueOfNormal, Integer valueOfBig, FoodType foodType, String description) {
}
