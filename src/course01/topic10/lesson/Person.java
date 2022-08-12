package course01.topic10.lesson;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void increaseAge(int increment) {

        if (increment < 0) {
            throw new IllegalArgumentException("Инкремент не может быть отрицательным");
        }
        this.age += increment;
    }

    public boolean isAdult() {
        return getAge() > 18;
    }

    public String toString() {
        return "Имя: " + this.name + "; Возраст: " + this.age;
    }
}
