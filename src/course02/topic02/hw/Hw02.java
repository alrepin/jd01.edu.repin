package course02.topic02.hw;

public class Hw02 {
   public static void main() {

      Hogwarts[] hogwartsStudents = {
               new Gryffindor("Гарри Поттер",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()
               ),
               new Gryffindor("Гермиона Грейнджер",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()
               ),
               new Gryffindor("Рон Уизли",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()
               ),
               new Hufflepuff("Захария Смит",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()),
               new Hufflepuff("Седрик Диггори",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()),
               new Hufflepuff("Джастин Финч-Флетчли",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()),
               new Slytherin("Драко Малфой",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()),
               new Slytherin("Грэхэм Монтегю",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()),
               new Slytherin("Грегори Гойл",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()),
               new Ravenclaw("Чжоу Чанг",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()),
               new Ravenclaw("Падма Патил",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()),
               new Ravenclaw("Маркус Белби",
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValuePositive(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval(),
                       creation.Common.randomValueIn0_100interval()),
       };

       for (int i = 0; i < hogwartsStudents.length; i++) {
           System.out.println(hogwartsStudents[i]);
       }

       course02.topic02.hw.Common.getStudByName(hogwartsStudents,
               "Захария Смит").compareCharacterRatioWithOtherStudent(hogwartsStudents,
               "Седрик Диггори");

       course02.topic02.hw.Common.getStudByName(hogwartsStudents,
               "Захария Смит").compareCommonSkillsWithOtherStudent(hogwartsStudents,
               "Седрик Диггори");

   }
}
