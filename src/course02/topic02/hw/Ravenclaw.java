package course02.topic02.hw;

import static course02.topic02.hw.Hw02.chkValueIn0_100interval;

public class Ravenclaw extends Hogwarts{
    private int smart;
    private int wisdom;
    private int wit;
    private int creation;

    public String facultyCaption() {
        return "Когтевран";
    }

    public Ravenclaw(String name, int sorcery, int transgression, int smart, int wisdom, int wit, int creation) {
        super(name, sorcery, transgression);
        this.smart = chkValueIn0_100interval("smart", smart);
        this.wisdom = chkValueIn0_100interval("wisdom", wisdom);
        this.wit = chkValueIn0_100interval("wit", wit);
        this.creation = chkValueIn0_100interval("creation", creation);
    }

    public int getSmart() {
        return smart;
    }

    public void setSmart(int smart) {
        this.smart = chkValueIn0_100interval("smart", smart);
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = chkValueIn0_100interval("wisdom", wisdom);
    }

    public int getWit() {
        return wit;
    }

    public void setWit(int wit) {
        this.wit = chkValueIn0_100interval("wit", wit);
    }

    public int getCreation() {
        return creation;
    }

    public void setCreation(int creation) {
        this.creation = chkValueIn0_100interval("creation", creation);
    }

    @Override
    public int calculateFacultyRatio() {
        return smart + wisdom + wit + creation;
    }

    @Override
    public String toString() {
        return "\n" + super.toString()
                + "\nУмище: " + smart
                + ", Мудрость: " + wisdom
                + ", Остроумие: " + wit
                + ", Творчество: " + creation;
    }
}
