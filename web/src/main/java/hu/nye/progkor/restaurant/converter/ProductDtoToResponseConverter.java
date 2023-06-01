package hu.nye.progkor.restaurant.converter;

import hu.nye.progkor.restaurant.model.dto.ProductDTO;
import hu.nye.progkor.restaurant.model.response.ProductResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductDtoToResponseConverter implements Converter<ProductDTO, ProductResponse> {

    @Override
    public ProductResponse convert(@NonNull final ProductDTO source) {
        log.info("Convert ProductDTO:{} to ProductResponse.", source);
        return new ProductResponse(
                source.id(),
                source.name(),
                source.valueOfNormal(),
                source.valueOfBig(),
                source.foodType(),
                source.description()
        );
    }
}
