package course02.topic02.hw;

public class  Gryffindor extends Hogwarts{
    private int nobility;
    private int honour;
    private int bravery;

    public int getCharacterRatio() {
        return nobility + honour + bravery;
    }

    private Nobility _nobility = new Nobility(0);
    private Honour _honour = new Honour(0);
    private Bravery _bravery = new Bravery(0);

    public Gryffindor(String name, int sorcery, int transgression, int nobility,
                      int honour, int bravery) {
        super(name, sorcery, transgression);
        _nobility.setValue(nobility);
        _honour.setValue(honour);
        _bravery.setValue(bravery);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_nobility, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_honour, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_bravery, name);
        this.nobility = nobility;
        this.honour = honour;
        this.bravery = bravery;
    }

    public int getNobility() {
        return nobility;
    }

    public void setNobility(int nobility) {
        course02.topic02.hw.Common.chkValueIn0_100interval(nobility);
        this.nobility = nobility;
    }

    public int getHonour() {
        return honour;
    }

    public void setHonour(int honour) {
        course02.topic02.hw.Common.chkValueIn0_100interval(honour);
        this.honour = honour;
    }

    public int getBravery() {
        return bravery;
    }

    public void setBravery(int bravery) {
        course02.topic02.hw.Common.chkValueIn0_100interval(bravery);
        this.bravery = bravery;
    }

    @Override
    public String toString() {
        _nobility.setValue(nobility);
        _honour.setValue(honour);
        _bravery.setValue(bravery);
        return "\n" + super.toString()
                + "\n" + _nobility
                + ", " + _honour
                + ", " + _bravery;
    }
}
