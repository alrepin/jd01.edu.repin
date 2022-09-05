package course02.topic02.hw;

public class Slytherin extends Hogwarts {
    private int cunning;
    private int determination;
    private int ambition;
    private int resourcefulness;
    private int powerLust;

    public int getCharacterRatio() {
        return cunning + determination + ambition + resourcefulness + powerLust;
    }

    private Cunning _cunning = new Cunning(0);
    private Determination _determination = new Determination(0);
    private Ambition _ambition = new Ambition(0);
    private Resourcefulness _resourcefulness = new Resourcefulness(0);
    private PowerLust _powerLust = new PowerLust(0);

    public Slytherin(String name, int sorcery, int transgression, int cunning,
                     int determination, int ambition, int resourcefulness, int powerLust) {
        super(name, sorcery, transgression);
        _cunning.setValue(cunning);
        _determination.setValue(determination);
        _ambition.setValue(ambition);
        _resourcefulness.setValue(resourcefulness);
        _powerLust.setValue(powerLust);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_cunning, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_determination, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_ambition, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_resourcefulness, name);
        course02.topic02.hw.Common.chkCharacterValueIn0_100interval(_powerLust, name);
        this.cunning = cunning;
        this.determination = determination;
        this.ambition = ambition;
        this.resourcefulness = resourcefulness;
        this.powerLust = powerLust;
    }

    public int getCunning() {
        return cunning;
    }

    public void setCunning(int cunning) {
        course02.topic02.hw.Common.chkValueIn0_100interval(cunning);
        this.cunning = cunning;
    }

    public int getDetermination() {
        return determination;
    }

    public void setDetermination(int determination) {
        course02.topic02.hw.Common.chkValueIn0_100interval(determination);
        this.determination = determination;
    }

    public int getAmbition() {
        return ambition;
    }

    public void setAmbition(int ambition) {
        course02.topic02.hw.Common.chkValueIn0_100interval(ambition);
        this.ambition = ambition;
    }

    public int getResourcefulness() {
        return resourcefulness;
    }

    public void setResourcefulness(int resourcefulness) {
        course02.topic02.hw.Common.chkValueIn0_100interval(resourcefulness);
        this.resourcefulness = resourcefulness;
    }

    public int getPowerLust() {
        return powerLust;
    }

    public void setPowerLust(int powerLust) {
        course02.topic02.hw.Common.chkValueIn0_100interval(powerLust);
        this.powerLust = powerLust;
    }

    @Override
    public String toString() {
        _cunning.setValue(cunning);
        _determination.setValue(determination);
        _ambition.setValue(ambition);
        _resourcefulness.setValue(resourcefulness);
        _powerLust.setValue(powerLust);
        return "\n" + super.toString()
                + "\n" + _cunning
                + ", " + _determination
                + ", " + _ambition
                + ", " + _resourcefulness
                + ", " + _powerLust;
    }
}
