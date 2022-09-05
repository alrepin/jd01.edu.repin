package course02.topic02.hw;

import static course02.topic02.hw.Hw02.chkValueIn0_100interval;

public class  Gryffindor extends Hogwarts{
    private int nobility;
    private int honour;
    private int bravery;

    public Gryffindor(String name, int sorcery, int transgression, int nobility, int honour, int bravery) {
        super(name, sorcery, transgression);
        this.nobility = chkValueIn0_100interval("nobility", nobility);
        this.honour = chkValueIn0_100interval("honour", honour);
        this.bravery = chkValueIn0_100interval("bravery", bravery);
    }

    public int getNobility() {
        return nobility;
    }

    public void setNobility(int nobility) {
        chkValueIn0_100interval("nobility", nobility);
        this.nobility = nobility;
    }

    public int getHonour() {
        return honour;
    }

    public void setHonour(int honour) {
        chkValueIn0_100interval("honour", honour);
        this.honour = honour;
    }

    public int getBravery() {
        return bravery;
    }

    public void setBravery(int bravery) {
        chkValueIn0_100interval("bravery", bravery);
        this.bravery = bravery;
    }

    @Override
    public String toString() {
        return "\n" + super.toString()
                + "\nБлагородство: " + nobility
                + ", Честь: " + honour
                + ", Храбрость: " + bravery;
    }
}
