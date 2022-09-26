package ga.repin.education.course01.topic10.lesson;

public class PersonService {
    public boolean isAdult(Person person) {
        return (person.getAge() >= 18);
    }

    public String whereToGo(Person person) {
        if (isAdult(person)) {
           return  "Иди в бар";
        } else {
           return  "Иди в школу";
        }
    }
}
