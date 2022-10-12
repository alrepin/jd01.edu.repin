package ga.repin.education.course02.topic02.hw;

import ga.repin.education.creation.Common;

public class Hw02 {
   public static void main() {

       Hogwarts harryPotter = new Gryffindor("Гарри Поттер", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts hermioneGranger = new Gryffindor("Гермиона Грейнджер", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts ronWeasley = new Gryffindor("Рон Уизли", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());

       Hogwarts dracoMalfoy = new Slytherin("Драко Малфой", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts grahamMontague = new Slytherin("Грэхэм Монтегю", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts gregoryGoyle = new Slytherin("Грегори Гойл", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());

       Hogwarts zachariasSmith = new Hufflepuff("Захария Смит", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts cedricDiggory = new Hufflepuff("Седрик Диггори", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts justinFinchFletchley = new Hufflepuff("Джастин Финч-Флетчли", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());

       Hogwarts choChang = new Ravenclaw("Чжоу Чанг", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts padmaPatil = new Ravenclaw("Падма Патил", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());
       Hogwarts marcusBelby = new Ravenclaw("Маркус Белби", Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval(), Common.randomValueIn0_100interval());

       System.out.println(zachariasSmith);
       System.out.println(justinFinchFletchley);
       zachariasSmith.compareFacultyStudentRatios(justinFinchFletchley);
       zachariasSmith.compareMagicStudentRatios(justinFinchFletchley);
       padmaPatil.compareFacultyStudentRatios(justinFinchFletchley);
       padmaPatil.compareMagicStudentRatios(justinFinchFletchley);

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
