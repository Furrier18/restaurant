package hu.nye.progkor.restaurant.service.impl;

import hu.nye.progkor.restaurant.model.FoodType;
import hu.nye.progkor.restaurant.model.Product;
import hu.nye.progkor.restaurant.model.dto.ProductDTO;
import hu.nye.progkor.restaurant.model.exception.NotFoundException;
import hu.nye.progkor.restaurant.repository.ProductRepository;
import hu.nye.progkor.restaurant.service.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Converter<ProductDTO, Product> productDtoToEntityConverter;
    private final Converter<Product, ProductDTO> productEntityToDtoConverter;

    @Override
    public List<ProductDTO> getAllProducts(@Nullable FoodType foodType) {
        log.info("Get all Products.");
        if (foodType != null){
            return productRepository.findByFoodType(foodType)
                    .stream()
                    .map(productEntityToDtoConverter::convert)
                    .toList();
        }else{
            return productRepository.findAll()
                    .stream()
                    .map(productEntityToDtoConverter::convert)
                    .toList();
        }
    }

    @Override
    public ProductDTO getProduct(final Long id) {
        log.info("Get a Product with ID:{}.", id);
        return productRepository.findById(id)
                .map(productEntityToDtoConverter::convert)
                .orElseThrow(() -> new NotFoundException("There is no Product with ID:" + id));
    }

    @Override
    public ProductDTO createProduct(final ProductDTO product) {
        log.info("Create a Product:{}.", product);
        return Optional.ofNullable(product)
                .map(productDtoToEntityConverter::convert)
                .map(productRepository::save)
                .map(productEntityToDtoConverter::convert)
                .orElseThrow(() -> new IllegalArgumentException("Provided parameter is invalid: " + product));
    }

    @Override
    public ProductDTO updateProduct(final Long id, final ProductDTO productChanges) {
        log.info("Update Product with ID:{} to {}.", id, productChanges);
        final Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("There is no Product with ID:" + id));
        product.setName(productChanges.name());
        product.setDescription(productChanges.description());
        product.setValueOfNormal(productChanges.valueOfNormal());
        product.setValueOfBig(productChanges.valueOfBig());
        final Product updatedProduct = productRepository.save(product);
        return productEntityToDtoConverter.convert(updatedProduct);
    }

    @Override
    public void deleteProduct(final Long id) {
        log.info("Delete Product with ID:{}.", id);
        productRepository.deleteById(id);
    }
}
