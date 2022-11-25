package ga.repin.education.course03.topic01.hw.recipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private String name;
    private Double weight;
    private String measureUnit;
}
