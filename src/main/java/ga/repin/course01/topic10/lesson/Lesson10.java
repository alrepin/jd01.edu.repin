package ga.repin.course01.topic10.lesson;
public class Lesson10 {

    public static void main() {
        System.out.println("\nЗанятие");
        PersonService PersonService= new PersonService();
        Person sarah = new Person("Sarah", 17);
        System.out.println(sarah);
        System.out.println(PersonService.whereToGo(sarah));
        sarah.increaseAge(1);
        System.out.println(sarah);
        System.out.println(PersonService.whereToGo(sarah));
    }
}
