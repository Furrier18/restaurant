package hu.nye.progkor.restaurant.converter;

import hu.nye.progkor.restaurant.model.Product;
import hu.nye.progkor.restaurant.model.dto.ProductDTO;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductEntityToDtoConverter implements Converter<Product, ProductDTO> {

    @Override
    public ProductDTO convert(@NonNull final Product source) {
        log.info("Convert Product:{} to ProductDTO.", source);
        return new ProductDTO(source.getId(),
                source.getName(),
                source.getValueOfNormal(),
                source.getValueOfBig(),
                source.getFoodType(),
                source.getDescription()
        );
    }
}
