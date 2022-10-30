package ga.repin.education.course02.topic02.lesson;

public abstract class Person {
    private String name;
    private int age;
    private int phoneNumber;

    public Person(String name, int age, int phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getPhoneNumber() {
        return this.phoneNumber;
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