package hu.nye.progkor.restaurant.converter;

import hu.nye.progkor.restaurant.model.dto.ProductDTO;
import hu.nye.progkor.restaurant.model.request.ProductRequest;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductRequestToDtoConverter implements Converter<ProductRequest, ProductDTO> {

    @Override
    public ProductDTO convert(@NonNull final ProductRequest source) {
        log.info("Convert ProductRequest:{} to ProductDTO.", source);
        return new ProductDTO(null,
                source.getName(),
                source.getValueOfNormal(),
                source.getValueOfBig(),
                source.getFoodType(),
                source.getDescription()
        );
    }
}
