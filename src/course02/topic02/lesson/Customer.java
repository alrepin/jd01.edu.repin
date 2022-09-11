package course02.topic02.lesson;

public class Customer extends Person{
    private int cardNumber;

    public Customer(String name, int age, int phoneNumber, int cardNumber) {
        super(name, age, phoneNumber);
        this.cardNumber = cardNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }


}
