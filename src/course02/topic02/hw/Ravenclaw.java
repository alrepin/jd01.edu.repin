package course02.topic02.hw;

public class Ravenclaw extends Hogwarts{
    private int smart;
    private int wisdom;
    private int wit;
    private int creation;

    public int getCharacterRatio() {
        return smart + wisdom + wit + creation;
    }
    private Smart _smart = new Smart(0);
    private Wisdom _wisdom = new Wisdom(0);
    private Wit _wit = new Wit(0);

    private Creation _creation = new Creation(0);

    public Ravenclaw(String name, int sorcery, int transgression, int smart,
                     int wisdom, int wit, int creation) {
        super(name, sorcery, transgression);
        _smart.setValue(smart);
        _wisdom.setValue(wisdom);
        _wit.setValue(wit);
        _creation.setValue(creation);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_smart, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_wisdom, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_wit, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_creation, name);
        this.smart = smart;
        this.wisdom = wisdom;
        this.wit = wit;
        this.creation = creation;
    }

    public int getSmart() {
        return smart;
    }

    public void setSmart(int smart) {
        course02.topic02.hw.Common.chkValueIn0_100interval(smart);
        this.smart = smart;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        course02.topic02.hw.Common.chkValueIn0_100interval(wisdom);
        this.wisdom = wisdom;
    }

    public int getWit() {
        return wit;
    }

    public void setWit(int wit) {
        course02.topic02.hw.Common.chkValueIn0_100interval(wit);
        this.wit = wit;
    }

    public int getCreation() {
        return creation;
    }

    public void setCreation(int creation) {
        course02.topic02.hw.Common.chkValueIn0_100interval(creation);
        this.creation = creation;
    }

    @Override
    public String toString() {
        _smart.setValue(smart);
        _wisdom.setValue(wisdom);
        _wit.setValue(wit);
        _creation.setValue(creation);
        return "\n" + super.toString()
                + "\n" + _smart
                + ", " + _wisdom
                + ", " + _wit
                + ", " + _creation;
    }
}
