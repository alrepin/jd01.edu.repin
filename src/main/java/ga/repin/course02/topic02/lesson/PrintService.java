package ga.repin.course02.topic02.lesson;

public class PrintService {

    public void print(Person[] people) {
        System.out.println("people.length = " + people.length);
        for (int i = 0; i < people.length; i++) {
            Person person = people[i];
            System.out.println("Имя " + person.getName()
                    + "; Возраст " + person.getAge()
                    + "; Телефон " + person.getPhoneNumber());
        }
        System.out.println();
    }

    }
