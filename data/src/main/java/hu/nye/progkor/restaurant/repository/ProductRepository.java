package hu.nye.progkor.restaurant.repository;

import java.util.List;

import hu.nye.progkor.restaurant.model.FoodType;
import hu.nye.progkor.restaurant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByFoodType(FoodType foodType);
}
