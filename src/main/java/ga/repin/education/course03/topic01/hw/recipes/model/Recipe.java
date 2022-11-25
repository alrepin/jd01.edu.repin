package ga.repin.education.course03.topic01.hw.recipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class Recipe {
    private int id;
    private String name;
    private int minuteTimer;
    private Set<Ingredient> ingredients;
    private List<String> steps;
    
}

