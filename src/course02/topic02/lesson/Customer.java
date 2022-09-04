package course02.topic02.lesson;

public class Customer {
    private String name;
    private int age;
    private int phoneNumber;
    private int cardNumber;

    public Customer(String name, int age, int phoneNumber, int cardNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }


}
