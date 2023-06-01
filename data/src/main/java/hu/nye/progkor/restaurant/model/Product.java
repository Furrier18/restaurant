package hu.nye.progkor.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@EnableJpaRepositories
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /** Normál adag ára */
    private Integer valueOfNormal;

    /** Nagy adag ára */
    private Integer valueOfBig;

     /** Étel kategória típus */
    private FoodType foodType;

    /** Leírás / miket tartalmaz */
    private String description;
}
