package course02.topic02.hw;

public class Hufflepuff extends Hogwarts{
    private int industriousness;
    private int loyalty;
    private int honesty;

    public int getCharacterRatio() {
        return industriousness + loyalty + honesty;
    }

    private Industriousness _industriousness = new Industriousness(0);
    private Loyalty _loyalty = new Loyalty(0);
    private Honesty _honesty = new Honesty(0);
    public Hufflepuff(String name, int sorcery, int transgression, int industriousness, int loyalty, int honesty) {
        super(name, sorcery, transgression);
        _industriousness.setValue(industriousness);
        _loyalty.setValue(loyalty);
        _honesty.setValue(honesty);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_industriousness, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_loyalty, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_honesty, name);
        this.industriousness = industriousness;
        this.loyalty = loyalty;
        this.honesty = honesty;
    }

    public int getIndustriousness() {
        return industriousness;
    }

    public void setIndustriousness(int industriousness) {
        course02.topic02.hw.Common.chkValueIn0_100interval(industriousness);
        this.industriousness = industriousness;
    }

    public int getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(int loyalty) {
        course02.topic02.hw.Common.chkValueIn0_100interval(loyalty);
        this.loyalty = loyalty;
    }

    public int getHonesty() {
        return honesty;
    }

    public void setHonesty(int honesty) {
        course02.topic02.hw.Common.chkValueIn0_100interval(honesty);
        this.honesty = honesty;
    }

    @Override
    public String toString() {
        _industriousness.setValue(industriousness);
        _loyalty.setValue(loyalty);
        _honesty.setValue(honesty);
        return "\n" + super.toString()
                + "\n" + _industriousness
                + ", " + _loyalty
                + ", " + _honesty;
    }
}
