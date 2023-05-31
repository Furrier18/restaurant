package hu.nye.progkor.restaurant.repository;

import hu.nye.progkor.restaurant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
