package course02.topic02.hw;

import static course02.topic02.hw.Hw02.chkValuePositive;

public class Hogwarts {
    private final String name;
    private int sorcery;
    private int transgression;

    public Hogwarts(String name, int sorcery, int transgression) {
        this.name = name;
        this.sorcery = chkValuePositive("sorcery", sorcery);
        this.transgression = chkValuePositive("transgression",transgression);
    }

    public String getName() {
        return name;
    }

    public int getSorcery() {
        return sorcery;
    }

    public void setSorcery(int sorcery) {
        this.sorcery = chkValuePositive("sorcery", sorcery);
    }

    public int getTransgression() {
        return transgression;
    }

    public void setTransgression(int transgression) {
        chkValuePositive("transgression", transgression);
        this.transgression = transgression;
    }

    @Override
    public String toString() {
        return "Имя: " + this.name
                + "\nТрансгрессия: " + getTransgression()
                + ", Колдовство: " + getSorcery();

    }
}
