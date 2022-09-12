package ga.repin.course02.topic02.hw;

public class Slytherin extends Hogwarts {
    private int cunning;
    private int determination;
    private int ambition;
    private int resourcefulness;
    private int powerLust;

    public String facultyCaption() {
        return "Слизерин";
    }

    public Slytherin(String name, int sorcery, int transgression, int cunning, int determination, int ambition, int resourcefulness, int powerLust) {
        super(name, sorcery, transgression);
        this.cunning = Hw02.chkValueIn0_100interval("cunning", cunning);
        this.determination = Hw02.chkValueIn0_100interval("determination", determination);
        this.ambition = Hw02.chkValueIn0_100interval("ambition", ambition);
        this.resourcefulness = Hw02.chkValueIn0_100interval("resourcefulness", resourcefulness);
        this.powerLust = Hw02.chkValueIn0_100interval("powerLust", powerLust);
    }

    public int getCunning() {
        return cunning;
    }

    public void setCunning(int cunning) {
        this.cunning = Hw02.chkValueIn0_100interval("cunning", cunning);
    }

    public int getDetermination() {
        return determination;
    }

    public void setDetermination(int determination) {
        this.determination = Hw02.chkValueIn0_100interval("determination", determination);
    }

    public int getAmbition() {
        return ambition;
    }

    public void setAmbition(int ambition) {
        this.ambition = Hw02.chkValueIn0_100interval("ambition", ambition);
    }

    public int getResourcefulness() {
        return resourcefulness;
    }

    public void setResourcefulness(int resourcefulness) {
        this.resourcefulness = Hw02.chkValueIn0_100interval("resourcefulness", resourcefulness);
    }

    public int getPowerLust() {
        return powerLust;
    }

    public void setPowerLust(int powerLust) {
        this.powerLust = Hw02.chkValueIn0_100interval("powerLust", powerLust);
    }

    @Override
    public int calculateFacultyRatio() {
        return cunning + determination + ambition + resourcefulness + powerLust;
    }

    @Override
    public String toString() {
        return "\n" + super.toString()
                + "\nХитрость: " + cunning
                + ", Решительность: " + determination
                + ", Амбициозность: " + ambition
                + ", Находчивость: " + resourcefulness
                + ", Жажда власти: " + powerLust;
    }
}
