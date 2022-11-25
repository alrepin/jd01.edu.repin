package ga.repin.education.course03.topic01.hw.recipes;

import ga.repin.education.course03.topic01.hw.recipes.model.Ingredient;
import ga.repin.education.course03.topic01.hw.recipes.model.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Set;

import static ga.repin.education.common.HtmlWrappers.*;
import static ga.repin.education.course03.topic01.hw.HwConstants.HW_ENDPOINT;

@Service
@SessionScope
public class RecipeServiceImpl implements RecipeService {
    private final List<Recipe> recipes;
    
    public RecipeServiceImpl(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    
    @Override
    public String index(String id) {
        return mainTheme(
                "Recipes API Description" +
                        HR +
                        "This interface is offered to add text/plain recipes to collection of recipe objects and to return all added objects in JSON format.<br>" +
                        "API access is provided at the following URLs:<br>" +
                        "<ul type=\"square\">" +
                        
                        "<li>" +
                        HW_ENDPOINT +
                        "/reference_sample will return recipe JSON example " +
                        hrefPrep(HW_ENDPOINT +
                                        "/reference_sample","[look]") +
                        "</li>" +
                        
                        "<li>" +
                        
                        "</ul>"
                //+
                //orderFormSnippet(id)
        );
    }
    
    @Override
    public Object getReference() {
        
        return List.of(
                new Recipe(1, "Сырники из творога", 30,
                        Set.of(new Ingredient("Творог", 350.0, "г"),
                                new Ingredient("Куриное яйцо", 2.0, "шт."),
                                new Ingredient("Пшеничная мука", 6.0, "ст. л."),
                                new Ingredient("Сахар", 2.0, "ст. л.")
                        ),
                        List.of(
                                "Смешайте весь творог с яйцами, сахаром и тщательно всё перемешайте.",
                                "Всыпьте в творог муку и тщательно перемешайте.",
                                "Поставьте сковороду на средний огонь и налейте в нее подсолнечное масло.",
                                "Слепите несколько небольших шариков из получившейся творожной массы и положите их на тарелку.",
                                "Затем по очереди обкатывайте творожные шарики в муке и выкладывайте на сковороду.",
                                "Обжаривайте сырники 1–2 минуты до появления золотистой корочки.",
                                "Затем переверните их на другую сторону и также обжарьте до золотистого состояния.",
                                "Повторяйте, пока творог не закончится."
                        )
                ),
                new Recipe(2, "Салат из красной фасоли с творожным сыром, красным луком и сезонным салатом", 7,
                        Set.of(new Ingredient("Специи по вкусу", -1.0, "по вкусу"),
                                new Ingredient("Консервированная фасоль", 400.0, "г"),
                                new Ingredient("Лимон", 1.0, "шт."),
                                new Ingredient("Чеснок", 2.0, "зубчик"),
                                new Ingredient("Оливковое масло", 50.0, "мл"),
                                new Ingredient("Рукола", 100.0, "г"),
                                new Ingredient("Творожный сыр", 200.0, "г"),
                                new Ingredient("Красный лук", 50.0, "г")
                        ),
                        List.of(
                                "Открыть две банки красной фасоли в собственном соку, слить сок и промыть фасоль холодной водой.",
                                "Готовую фасоль смешать с мелко нарубленным красным луком, зеленью, давленым чесноком, оливковым маслом, лимонным соком и творожным сыром.",
                                "Посолить, поперчить, дать продуктам две минуты притереться друг к другу и подавать к столу."
                        )
                ),
                new Recipe(3, "Чечевичный суп с мятой", 30,
                        Set.of(new Ingredient("Красная чечевица",150.0, "г"),
                                new Ingredient("Репчатый лук", 1.0, "головка"),
                                new Ingredient("Морковь", 1.0, "шт."),
                                new Ingredient("Подсолнечное масло", 30.0, "мл"),
                                new Ingredient("Сливочное масло", 15.0, "г"),
                                new Ingredient("Пшеничная мука", 30.0, "г"),
                                new Ingredient("Сливки 33%", 50.0, "ст. л."),
                                new Ingredient("Специи", -1.0, "по вкусу"),
                                new Ingredient("Лимон", 0.5, "шт."),
                                new Ingredient("Мята", -1.0, "по вкусу")
                        ),
                        List.of(
                                "В небольшую кастрюлю налить литр воды и засыпать промытую чечевицу.",
                                "Поставить кастрюлю на средний огонь.",
                                "Натереть небольшую морковь на крупной терке, мелко нарезать лук.",
                                "Как только чечевица начнет кипеть, надо убавить огонь, а затем долить еще 200 мл воды или бульона.",
                                "Варить еще десять минут.",
                                "Разогреть широкую плоскую сковороду, добавить туда подсолнечное и сливочное масло.",
                                "Обжарить лук и морковь.",
                                "Добавить обжаренные овощи в кастрюлю, влить сливки.",
                                "Взбить суп ручным блендером, чтобы он превратился в густое пюре.",
                                "Суп можно подавать к столу."
                        )
                ),
                new Recipe(4,"Салат с креветками и кунжутом", 20,
                        Set.of(new Ingredient("Помидоры", 3.0, "шт."),
                                new Ingredient("Королевские креветки", 300.0, "г"),
                                new Ingredient("Зеленый салат", 1.0, "пучок"),
                                new Ingredient("Огурцы", 2.0, "шт."),
                                new Ingredient("Специи", -1.0, "по вкусу"),
                                new Ingredient("Майонез", -1.0, "по вкусу"),
                                new Ingredient("Кунжутные семечки", 3.0, "ст.л.")
                        ),
                        List.of(
                                "Порезать овощи крупно, салат порвать на куски.",
                                "Довести до кипения сильно соленую воду и добавить креветки.",
                                "После кипения варить 5 минут.",
                                "Очистить креветки от панциря.",
                                "Смешать овощи и креветки.",
                                "Посыпать кунжутными семечками и заправить майонезом."
                        )
                ),
                new Recipe(5,"Творожные пончики в сахарной пудре", 40,
                        Set.of(new Ingredient("Творог", 250.0, "г"),
                                new Ingredient("Куриное яйцо", 3.0, "шт."),
                                new Ingredient("Пшеничная мука", 8.0, "ст. л."),
                                new Ingredient("Сахар", -1.0, "по вкусу"),
                                new Ingredient("Соль", -1.0, "по вкусу"),
                                new Ingredient("Оливковое масло", -1.0, "по вкусу"),
                                new Ingredient("Сода", 0.5, "ч. л."),
                                new Ingredient("Сахарная пудра с ванилью", -1.0, "по вкусу")
                        ),
                        List.of(
                                "В миске смешать творог, яйца, муку, сахар, соду и соль до однородной консистенции.",
                                "В небольшом сотейнике оливковое масло хорошо разогреть.",
                                "При помощи чайной ложки или руками скатать из теста шарики, каждый размером чуть меньше грецкого ореха.",
                                "Бросить пончики в кипящее масло и жарить на небольшом огне, постоянно переворачивая шумовкой.",
                                "Готовые пончики выложить на бумажное полотенце и оставить на одну-две минуты — чтобы оно впитало лишнее масло.",
                                "Подавать пончики горячими, выложив на блюдо и посыпав сахарной пудрой, смешанной с ванилином."
                        )
                )
        );
    }
}
