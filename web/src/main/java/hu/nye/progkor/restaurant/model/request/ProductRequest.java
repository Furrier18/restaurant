package hu.nye.progkor.restaurant.model.request;


import hu.nye.progkor.restaurant.model.FoodType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@EqualsAndHashCode
@Getter
@JsonDeserialize(builder = ProductRequest.ProductRequestBuilder.class)
@ToString
public class ProductRequest {

    private final String name;
    private final Integer valueOfNormal;
    private final Integer valueOfBig;
    private final FoodType foodType;
    private final String description;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ProductRequestBuilder {

    }
}
