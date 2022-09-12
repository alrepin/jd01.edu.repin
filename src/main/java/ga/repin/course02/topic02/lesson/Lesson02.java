package ga.repin.course02.topic02.lesson;

public class Lesson02 {
    public static void main() {
        System.out.println("Занятие\n");

        /*Person[] people = {
                new Person("Сара", 30, 112),
                new Person("Джон", 12, 113),
                new Person("Иван", 12, 114),
                new Person("Том", 12, 115),
                new Person("Джо", 23, 116),
        };*/

        Customer[] customers = {
                new Customer("Сара", 30, 112, 11321),
                new Customer("Иван", 25, 114, 11322),
                new Customer("Том", 35, 115, 11323),
        };

        Gamer[] gamers = {
                new Gamer("Джо", 23, 116, "PS"),
                new Gamer("Джон", 12, 113, "PC"),
        };

        PrintService printService = new PrintService();
        //printService.print(people);
        printService.print(customers);
        printService.print(gamers);
    }
}
