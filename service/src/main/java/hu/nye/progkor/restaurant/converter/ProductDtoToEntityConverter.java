package hu.nye.progkor.restaurant.converter;

import hu.nye.progkor.restaurant.model.Product;
import hu.nye.progkor.restaurant.model.dto.ProductDTO;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductDtoToEntityConverter implements Converter<ProductDTO, Product> {

    @Override
    public Product convert(@NonNull final ProductDTO source) {
        log.info("Convert ProductDTO:{} to Product.", source);
        return new Product(source.id(),
                source.name(),
                source.valueOfNormal(),
                source.valueOfBig(),
                source.foodType(),
                source.description()
        );
    }
}
