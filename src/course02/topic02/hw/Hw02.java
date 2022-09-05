package course02.topic02.hw;

import course02.topic02.lesson.Customer;
import creation.Common;

public class Hw02 {
   public static void main() {

       Hogwarts harryPotter = new Gryffindor("Гарри Поттер", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts hermioneGranger = new Gryffindor("Гермиона Грейнджер", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts ronWeasley = new Gryffindor("Рон Уизли", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), 350);

       Hogwarts dracoMalfoy = new Slytherin("Драко Малфой", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts grahamMontague = new Slytherin("Грэхэм Монтегю", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts gregoryGoyle = new Slytherin("Грегори Гойл", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());

       Hogwarts zachariasSmith = new Hufflepuff("Захария Смит", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts cedricDiggory = new Hufflepuff("Седрик Диггори", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts justinFinchFletchley = new Hufflepuff("Джастин Финч-Флетчли", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());

       Hogwarts choChang = new Ravenclaw("Чжоу Чанг", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts padmaPatil = new Ravenclaw("Падма Патил", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts marcusBelby = new Ravenclaw("Маркус Белби", Common.randomValuePositive(), Common.randomValuePositive(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());

       System.out.println(harryPotter);

   }
    static int chkValueIn0_100interval(String name, int value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Неверное значение параметра " + name + ": " + value
                    + ", \nсвойства оцениваются в целочисленном эквиваленте от 0 до 100");
        } else {
            return value;
        }
    }

    static int chkValuePositive(String name, int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Неверное значение параметра " + name + ": " + value
                    + ", \nсвойства оцениваются в целочисленном эквиваленте от 0 до 100");
        } else {
            return value;
        }
    }

}
