package hu.nye.progkor.restaurant.populator.impl;

import hu.nye.progkor.restaurant.model.FoodType;
import hu.nye.progkor.restaurant.model.Product;
import hu.nye.progkor.restaurant.populator.DBPopulator;
import hu.nye.progkor.restaurant.repository.ProductRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(1)
public class ProductInitializer implements DBPopulator {

    private static final List<Product> PRODUCTS = List.of(
            new Product(null, "Sonkás", 1200, 2000, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, sonka, sajt"),
            new Product(null, "Szalámis", 1200, 2000, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, szalámi, sajt"),
            new Product(null, "Hawaii", 1400, 2320, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, sonka, ananász, kukorica, sajt"),
            new Product(null, "Songoku", 1400, 2320, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, sonka, gomba, kukorica, sajt"),
            new Product(null, "Nyári", 1300, 2200, FoodType.PIZZA_FOOD,
                    "barbecue alap, bacon, sonka, kukorica, mozarella"),
            new Product(null, "Őszi", 1300, 2200, FoodType.PIZZA_FOOD,
                    "mustáros-tejfölös alap, csirkemell, szalámi, kukorica, méz, sajt"),
            new Product(null, "Téli", 1300, 2200, FoodType.PIZZA_FOOD,
                    "carbonare alap, hagyma, paprika, sajt"),
            new Product(null, "Magyaros", 1400, 2350, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, kolbász, bacon, hagyma, paradicsom, paprika"),
            new Product(null, "Húsimádó", 1600, 2920, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, mindenféle hús"),
            new Product(null, "Cyprus", 1550, 2800, FoodType.PIZZA_FOOD,
                    "fokhagymás-tejfölös alap, tarja, bacon, lilahagyma, füstölt sajt"),
            new Product(null, "Snoopy", 1600, 2600, FoodType.PIZZA_FOOD,
                    "fokhagymás-tejfölös alap, csirkemell, fokhagyma, gomba, kolbász, sajt"),
            new Product(null, "Fitness", 1550, 2630, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, csirkemell, gomba, paradicsom, sajt"),
            new Product(null, "4 évszak", 1600, 2500, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, sonka, gomba, kukorica, ananász, borsó, sajt"),
            new Product(null, "Angkor", 1920, 3110, FoodType.PIZZA_FOOD,
                    "tejfölös alap, kukorica, tarja, hagyma, bacon, sajt"),
            new Product(null, "Maya", 1600, 2930, FoodType.PIZZA_FOOD,
                    "fokhagymás-tejfölös alap, tarja, csirkemell, hagyma, bacon, sajt"),
            new Product(null, "4 sajtos", 1530, 2960, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, mozarella, trapista, füstölt, gouda sajt"),
            new Product(null, "Mexikói", 1520, 2920, FoodType.PIZZA_FOOD,
                    "taco alap, marhahús, bab, paprika, jalapeno, sajt, tortilla"),
            new Product(null, "Szecsuáni", 1620, 2620, FoodType.PIZZA_FOOD,
                    "paradicsomos alap, csirkemell, szecsuáni mártás, vörösbab, sajt"),
            new Product(null, "Bolognais", 1520, 2550, FoodType.PIZZA_FOOD,
                    "bolognai alap, hagyma, paradicsom, sajt"),
            new Product(null, "Tulaj kedvence", 1360, 2550, FoodType.PIZZA_FOOD,
                    "tejfölös alap, sonka, kukorica, hagyma, sajt"),
            new Product(null, "Gyros", 1000, 1200, FoodType.OTHER_FOOD,
                    "kifli, csirkemell, zöldség, mártás, sajt"),
            new Product(null, "Gyros pitában", 800, null, FoodType.OTHER_FOOD,
                    "pita, csirkemell, zöldség, mártás, sajt"),
            new Product(null, "Gyros tál", 1000, 1250, FoodType.OTHER_FOOD,
                    "sült burgonya, csirkemell, zöldség, mártás, sajt"),
            new Product(null, "Vega tál", 700, null, FoodType.OTHER_FOOD,
                    "sült burgonya, zöldség, mártás, sajt"),
            new Product(null, "Hamburger", 690, 950, FoodType.OTHER_FOOD,
                    "buci, hús, zöldség, ketchup, mustár, sajt"),
            new Product(null, "Amerikai hamburger", 1150, 1400, FoodType.OTHER_FOOD,
                    "buci, hús, bacon, barbecue, pirított hagyma, sajt"),
            new Product(null, "Hot-dog", 300, null, FoodType.OTHER_FOOD,
                    "kifli, virsli, ketchup, mustár, majonéz"),
            new Product(null, "Angkor hot-dog", 550, null, FoodType.OTHER_FOOD,
                    "kifli, virsli, mártás, zöldség, sajt"),
            new Product(null, "Wimpy", 880, null, FoodType.OTHER_FOOD,
                    "kifli, sajt, baconbe tekert sült virsli, zöldség, mártás"),
            new Product(null, "Shaorma", 990, null, FoodType.OTHER_FOOD,
                    "tortilla tészta, csirkemell, zöldségek, csemegeuborka, mártás, sajt"),
            new Product(null, "Chicken nuggets", 1000, null, FoodType.OTHER_FOOD,
                    "sült burgonya, 6db nuggets, mártás"),
            new Product(null, "Rántott sajt", 900, null, FoodType.OTHER_FOOD,
                    "sült burgonya, 3db sajt, mártás"),
            new Product(null, "Halrudacskák", 1200, null, FoodType.OTHER_FOOD,
                    "sült burgonya, 5db nuggets, mártás"),
            new Product(null, "Angkor saláta", 820, null, FoodType.OTHER_FOOD,
                    "saláta, csirkemell, zöldségek, mártás, sajt, olivabogyó"),
            new Product(null, "Fitness saláta", 450, null, FoodType.OTHER_FOOD,
                    "saláta, zöldségek, mártás, sajt")

    );

    private final ProductRepository productRepository;

    public ProductInitializer(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void populateDatabase() {
        log.info("Initialize Products...");
        productRepository.saveAll(PRODUCTS);
        log.info("Finished initialization of Products.");
    }
}
