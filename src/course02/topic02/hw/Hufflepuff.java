package course02.topic02.hw;

import static course02.topic02.hw.Hw02.chkValueIn0_100interval;

public class Hufflepuff extends Hogwarts{
    private int industriousness;
    private int loyalty;
    private int honesty;

    public String facultyCaption() {
        return "Пуффендуй";
    }

    public Hufflepuff(String name, int sorcery, int transgression, int industriousness, int loyalty, int honesty) {
        super(name, sorcery, transgression);
        this.industriousness = chkValueIn0_100interval("industriousness", industriousness);
        this.loyalty = chkValueIn0_100interval("loyalty", loyalty);
        this.honesty = chkValueIn0_100interval("honesty", honesty);
    }

    public int getIndustriousness() {
        return industriousness;
    }

    public void setIndustriousness(int industriousness) {
        this.industriousness = chkValueIn0_100interval("industriousness", industriousness);
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        this.loyalty = chkValueIn0_100interval("loyalty", loyalty);
    }

    public int getHonesty() {
        return honesty;
    }

    public void setHonesty(int honesty) {
        this.honesty = chkValueIn0_100interval("honesty", honesty);
    }

    @Override
    public int calculateFacultyRatio() {
        return industriousness + loyalty + honesty;
    }

    @Override
    public String toString() {
        return "\n" + super.toString()
                + "\nТрудолюбие: " + industriousness
                + ", Верность: " + loyalty
                + ", Честность: " + honesty;
    }
}
