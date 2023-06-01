package hu.nye.progkor.restaurant.service;

import hu.nye.progkor.restaurant.model.FoodType;
import hu.nye.progkor.restaurant.model.dto.ProductDTO;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts(@Nullable FoodType foodType);

    ProductDTO getProduct(Long id);

    ProductDTO createProduct(ProductDTO product);

    ProductDTO updateProduct(Long id, ProductDTO productChanges);

    void deleteProduct(Long id);
}
