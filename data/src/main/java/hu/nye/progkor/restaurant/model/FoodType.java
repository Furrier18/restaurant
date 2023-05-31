package hu.nye.progkor.restaurant.model;

/** A menüben is választható étel típusokat tartalmazó FoodType típus */
public enum FoodType {

    PIZZA_FOOD("Pizza"),           /** Pizza kategóriába tartozó étel test */
    OTHER_FOOD("Egyéb");           /** Gyrosok, hamburgerek és egyéb ételek */

    private final String value;

    FoodType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
