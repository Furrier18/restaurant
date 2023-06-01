package hu.nye.progkor.restaurant.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import hu.nye.progkor.restaurant.model.FoodType;
import hu.nye.progkor.restaurant.model.Product;
import hu.nye.progkor.restaurant.model.dto.ProductDTO;
import hu.nye.progkor.restaurant.model.exception.NotFoundException;
import hu.nye.progkor.restaurant.repository.ProductRepository;
import hu.nye.progkor.restaurant.service.ProductService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.hamcrest.Matchers;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.convert.converter.Converter;

class ProductServiceImplTest {

    private static final Long PRODUCT_ID = 22L;
    private static final String PRODUCT_NAME = "GYROS LÁNGOS";
    private static final int PRODUCT_NORMAL = 1600;
    private static final int PRODUCT_BIG = 2200;
    private static final FoodType PRODUCT_FOOD_TYPE = FoodType.OTHER_FOOD;
    private static final String PRODUCT_DESCRIPTION = "A gyros és a lángos legendás fúziója";
    private static final Product PRODUCT = new Product(PRODUCT_ID, PRODUCT_NAME, PRODUCT_NORMAL, PRODUCT_BIG, PRODUCT_FOOD_TYPE, PRODUCT_DESCRIPTION);
    private static final Product UNSAVED_PRODUCT = new Product(null, PRODUCT_NAME, PRODUCT_NORMAL, PRODUCT_BIG, PRODUCT_FOOD_TYPE, PRODUCT_DESCRIPTION);
    private static final ProductDTO PRODUCT_DTO = new ProductDTO(PRODUCT_ID, PRODUCT_NAME, PRODUCT_NORMAL, PRODUCT_BIG, PRODUCT_FOOD_TYPE, PRODUCT_DESCRIPTION);
    private static final ProductDTO UNSAVED_PRODUCT_DTO = new ProductDTO(null, PRODUCT_NAME, PRODUCT_NORMAL, PRODUCT_BIG, PRODUCT_FOOD_TYPE, PRODUCT_DESCRIPTION);
    private static final List<Product> PRODUCTS = Arrays.asList(PRODUCT, PRODUCT);
    private static final List<ProductDTO> DTO_PRODUCTS = Arrays.asList(PRODUCT_DTO, PRODUCT_DTO);
    private static final String PRODUCT_NOT_FOUND_EXCEPTION_ERROR_MESSAGE = "There is no Product with ID:" + PRODUCT_ID;
    private static final String PRODUCT_ILLEGAL_ARGUMENT_EXCEPTION_ERROR_MESSAGE = "Provided parameter is invalid: null";

    @Mock
    private ProductRepository productRepository;
    @Mock
    private Converter<ProductDTO, Product> productDtoToEntityConverter;
    @Mock
    private Converter<Product, ProductDTO> productEntityToDtoConverter;

    private ProductService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new ProductServiceImpl(productRepository, productDtoToEntityConverter, productEntityToDtoConverter);
    }

    @Test
    void getAllProductsShouldReturnConvertedProductsWhenThereWereSavedProducts() {
        // given
        given(productRepository.findAll()).willReturn(PRODUCTS);
        given(productEntityToDtoConverter.convert(PRODUCT)).willReturn(PRODUCT_DTO);
        // when
        final List<ProductDTO> actual = underTest.getAllProducts(null);
        // then
        assertThat(actual, Matchers.containsInAnyOrder(DTO_PRODUCTS.toArray()));
    }

    @Test
    void getAllProductsShouldReturnEmptyListWhenThereWasNoAnySavedProducts() {
        // given
        given(productRepository.findAll()).willReturn(Collections.emptyList());
        // when
        final List<ProductDTO> actual = underTest.getAllProducts(null);
        // then
        assertThat(actual, IsCollectionWithSize.hasSize(0));
    }

    @Test
    void getAllOtherProductsShouldReturnConvertedOtherProductsWhenThereWereSavedProducts() {
        // given
        given(productRepository.findByFoodType(FoodType.OTHER_FOOD)).willReturn(PRODUCTS);
        given(productEntityToDtoConverter.convert(PRODUCT)).willReturn(PRODUCT_DTO);
        // when
        final List<ProductDTO> actual = underTest.getAllProducts(FoodType.OTHER_FOOD);
        // then
        assertThat(actual, Matchers.containsInAnyOrder(DTO_PRODUCTS.toArray()));
    }

    @Test
    void getAllPizzaProductsShouldReturnEmptyListWhenThereWasNoAnySavedPizzaProductsOnlyJustOtherFoodType() {
        // given
        given(productRepository.findByFoodType(FoodType.PIZZA_FOOD)).willReturn(Collections.emptyList());
        // when
        final List<ProductDTO> actual = underTest.getAllProducts(FoodType.PIZZA_FOOD);
        // then
        assertThat(actual, IsCollectionWithSize.hasSize(0));
    }

    @Test
    void getProductShouldReturnConvertedProductWhenGivenIDOfExistingProduct() {
        // given
        given(productRepository.findById(PRODUCT_ID)).willReturn(Optional.of(PRODUCT));
        given(productEntityToDtoConverter.convert(PRODUCT)).willReturn(PRODUCT_DTO);
        // when
        final ProductDTO actual = underTest.getProduct(PRODUCT_ID);
        // then
        assertThat(actual, equalTo(PRODUCT_DTO));
    }

    @Test
    void getProductShouldThrowNotFoundExceptionWhenGivenIDOfNotExistingProduct() {
        // given
        given(productRepository.findById(PRODUCT_ID)).willReturn(Optional.empty());
        // when - then
        final NotFoundException actual = assertThrows(NotFoundException.class, () -> underTest.getProduct(PRODUCT_ID));
        assertThat(actual.getMessage(), equalTo(PRODUCT_NOT_FOUND_EXCEPTION_ERROR_MESSAGE));
    }

    @Test
    void createProductShouldThrowIllegalArgumentExceptionWhenGivenNullAsProduct() {
        // given
        // when - then
        final IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> underTest.createProduct(null));
        assertThat(actual.getMessage(), equalTo(PRODUCT_ILLEGAL_ARGUMENT_EXCEPTION_ERROR_MESSAGE));
    }

    @Test
    void createProductShouldReturnSavedProductWhenGivenProductDetails() {
        // given
        given(productRepository.save(UNSAVED_PRODUCT)).willReturn(PRODUCT);
        given(productEntityToDtoConverter.convert(PRODUCT)).willReturn(PRODUCT_DTO);
        given(productDtoToEntityConverter.convert(UNSAVED_PRODUCT_DTO)).willReturn(UNSAVED_PRODUCT);
        // when
        final ProductDTO actual = underTest.createProduct(UNSAVED_PRODUCT_DTO);
        // then
        assertThat(actual, equalTo(PRODUCT_DTO));
    }

    @Test
    void updateProductShouldThrowNotFoundExceptionWhenGivenIDOfNotExistingProduct() {
        // given
        given(productRepository.findById(PRODUCT_ID)).willReturn(Optional.empty());
        // when - then
        final NotFoundException actual = assertThrows(NotFoundException.class, () -> underTest.updateProduct(PRODUCT_ID, PRODUCT_DTO));
        assertThat(actual.getMessage(), equalTo(PRODUCT_NOT_FOUND_EXCEPTION_ERROR_MESSAGE));
    }

    @Test
    void updateProductShouldUpdateTheProductWhenGivenIDOfExistingProductAndProductDetails() {
        // given
        final Product iceCream = new Product(PRODUCT_ID, "Fagylalt", 500, 700, FoodType.OTHER_FOOD, "Vanilia fagylalt.");
        given(productRepository.findById(PRODUCT_ID)).willReturn(Optional.of(iceCream));
        given(productEntityToDtoConverter.convert(PRODUCT)).willReturn(PRODUCT_DTO);
        given(productRepository.save(PRODUCT)).willReturn(PRODUCT);
        // when
        final ProductDTO actual = underTest.updateProduct(PRODUCT_ID, PRODUCT_DTO);
        // then
        verify(productRepository).save(PRODUCT);
        assertThat(actual, equalTo(PRODUCT_DTO));
    }

    @Test
    void deleteProductShouldDelegateDeleteByIdWhenGivenProductID() {
        // given
        // when
        underTest.deleteProduct(PRODUCT_ID);
        // then
        verify(productRepository).deleteById(PRODUCT_ID);
    }
}
