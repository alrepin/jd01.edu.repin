package ga.repin.education.course02.topic02.hw;

public abstract class Hogwarts {
    private final String name;
    private int sorcery;
    private int transgression;

    public abstract String facultyCaption();

    public Hogwarts(String name, int sorcery, int transgression) {
        this.name = name;
        this.sorcery = Hw02.chkValuePositive("sorcery", sorcery);
        this.transgression = Hw02.chkValuePositive("transgression",transgression);
    }

    public String getName() {
        return name;
    }

    public int getSorcery() {
        return sorcery;
    }

    public void setSorcery(int sorcery) {
        this.sorcery = Hw02.chkValuePositive("sorcery", sorcery);
    }

    public int getTransgression() {
        return transgression;
    }

    public void setTransgression(int transgression) {
        Hw02.chkValuePositive("transgression", transgression);
        this.transgression = transgression;
    }

    public void printWhoBetterOnFaculty(Hogwarts betterStud, Hogwarts worseStud, boolean same) {
        if (same) {
            System.out.println("\nу "
                    + betterStud.getName() + " и " + worseStud.getName() + " \n"
                    + " имеют одинаковую суммарную харизму " + betterStud.calculateFacultyRatio()
                    + " на факультете " + betterStud.facultyCaption());
        } else {
                System.out.println("\n"
                        + betterStud.getName() + " (сумма баллов: "
                        + betterStud.calculateFacultyRatio()
                        + ") лучший " + betterStud.facultyCaption() + "ец, чем " + worseStud.getName()
                        + " (сумма баллов: " + worseStud.calculateFacultyRatio() + ")");
        }
    }
    public void printWhoHaveMorePower(Hogwarts betterStud, Hogwarts worseStud, boolean same) {
        if (same) {
            System.out.println("\nу "
                    + betterStud.getName() + " и " + worseStud.getName() + " \n"
                    + " имеют одинаковую суммарную силу магии " + betterStud.calculateMagicRatio());
        } else {
            System.out.println("\n"
                    + betterStud.getName() + " (суммарная магия: "
                    + betterStud.calculateMagicRatio()
                    + ") обладает большей мощностью магии, чем " + worseStud.getName()
                    + " (суммарная магия: " + worseStud.calculateMagicRatio() + ")");
        }
    }

    public void compareMagicStudentRatios(Hogwarts otherStudent) {
        int studRatio1 = this.calculateMagicRatio();
        int studRatio2 = otherStudent.calculateMagicRatio();
        if (studRatio1 > studRatio2) {
            printWhoHaveMorePower(this, otherStudent, false);
        } else if (studRatio1 < studRatio2) {
            printWhoHaveMorePower(otherStudent, this, false);
        } else {
            printWhoHaveMorePower(this, otherStudent, true);
        }
    }

    public void compareFacultyStudentRatios(Hogwarts otherStudent) {
        if (otherStudent.facultyCaption() != this.facultyCaption()) {
            System.out.println("\nНельзя сравнивать студентов разных факультетов! " + otherStudent.getName()
                    + " - " + otherStudent.facultyCaption() + "ец, а " + this.getName() + " - " + this.facultyCaption() + "ец");
            return;
        }
        int studRatio1 = this.calculateFacultyRatio();
        int studRatio2 = otherStudent.calculateFacultyRatio();
        if (studRatio1 > studRatio2) {
            printWhoBetterOnFaculty(this, otherStudent, false);
        } else if (studRatio1 < studRatio2) {
            printWhoBetterOnFaculty(otherStudent, this, false);
        } else {
            printWhoBetterOnFaculty(this, otherStudent,  true);
        }
    }

    public int calculateMagicRatio() {
        return this.getSorcery() + this.getTransgression();
    }

    public abstract int calculateFacultyRatio();

    @Override
    public String toString() {
        return "Имя: " + this.name
                + "\nТрансгрессия: " + getTransgression()
                + ", Колдовство: " + getSorcery();

    }
}
