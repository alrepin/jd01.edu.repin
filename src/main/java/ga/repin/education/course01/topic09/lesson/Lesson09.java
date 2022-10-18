package ga.repin.education.course01.topic09.lesson;

public class Lesson09 {

    public static void main() {
        System.out.println("Занятие\n");
        Person sarah = new Person("Sarah", 30);
        System.out.println("sarah.name = " + sarah.getName());
        System.out.println("sarah.age = " + sarah.getAge());
        Person john = new Person("John", 13);
        System.out.println("john.name = " + john.getName());
        System.out.println("john.age = " + john.getAge());
        sarah.setAge(31);
        System.out.println("sarah.name = " + sarah.getName());
        System.out.println("sarah.age = " + sarah.getAge());

        //пробую создать массив объектов класса Person
        Person[] student = new Person[4];
        for (int i = 0; i < student.length; i++) {
            student[i] = new Person("person" + i, (i + 2) * 10);
        }
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getName() + " - " + student[i].getAge());
        }



    }
}
