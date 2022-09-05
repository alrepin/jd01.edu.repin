package course02.topic02.hw;

public class Hogwarts {
    private final String name;
    private int sorcery;
    private int transgression;

    public int getCharacterRatio() {
        return this.getCharacterRatio();
    }
    public Hogwarts(String name, int sorcery, int transgression) {
        this.name = name;
        this.sorcery = sorcery;
        this.transgression = transgression;
    }

    public String getName() {
        return name;
    }

    public int getSorcery() {
        return sorcery;
    }

    public void setSorcery(int sorcery) {
        course02.topic02.hw.Common.chkValuePositive(sorcery);
        this.sorcery = sorcery;
    }

    public void compareCommonSkillsWithOtherStudent(Hogwarts[] hogwarts, String name) {
        Hogwarts otherStudent = Common.getStudByName(hogwarts, name);
        Hogwarts maxTransgressionStudent = null;
        Hogwarts minTransgressionStudent = null;
        Hogwarts maxSorceryStudent = null;
        Hogwarts minSorceryStudent = null;
        if (otherStudent.getTransgression() > this.getTransgression()) {
            maxTransgressionStudent = otherStudent;
            minTransgressionStudent = this;
        } else {
            maxTransgressionStudent = this;
            minTransgressionStudent = otherStudent;
        }
        if (otherStudent.getSorcery() > this.getSorcery()) {
            maxSorceryStudent = otherStudent;
            minSorceryStudent = this;
        } else {
            maxSorceryStudent = this;
            minSorceryStudent = otherStudent;
        }
        if (maxSorceryStudent.getSorcery()
                != minSorceryStudent.getSorcery()) {
            System.out.println("\n"
                    + maxSorceryStudent.getName()
                    + " обладает бОльшей мощностью магии ("
                    + maxSorceryStudent.getSorcery()
                    + "), чем "
                    + minSorceryStudent.getName()
                    + " ("
                    + minSorceryStudent.getSorcery()
                    + ")"
            );
        } else {
            System.out.println("\n"
                    + maxSorceryStudent.getName()
                    + " и "
                    + minSorceryStudent.getName()
                    + " обладают одинаковой колдовской силой - "
                    + maxSorceryStudent.getSorcery()
            );
        }
        if (maxTransgressionStudent.getTransgression()
                != minTransgressionStudent.getTransgression()) {
            System.out.println("\n"
                    + maxTransgressionStudent.getName()
                    + " обладает бОльшей дальностью трансгрессии ("
                    + maxTransgressionStudent.getTransgression()
                    + "), чем "
                    + minTransgressionStudent.getName()
                    + " ("
                    + minTransgressionStudent.getTransgression()
                    + ")"
            );
        } else {
            System.out.println("\n"
                    + maxTransgressionStudent.getName()
                    + " и "
                    + minTransgressionStudent.getName()
                    + " трансгессируют на равное расстояние - "
                    + maxTransgressionStudent.getTransgression()
            );
        }
        maxTransgressionStudent = null;
        minTransgressionStudent = null;
        maxSorceryStudent = null;
        minSorceryStudent = null;
    }

    public void compareCharacterRatioWithOtherStudent(Hogwarts[] hogwarts, String name) {
        Hogwarts otherStudent = Common.getStudByName(hogwarts, name);
        if (otherStudent.getFacultyAffiliation() != this.getFacultyAffiliation()) {
            System.out.println("Нельзя сравнивать студентов разных факультетов: "
                    + otherStudent.getFacultyAffiliation()
                    + " и "
                    + this.getFacultyAffiliation());
            otherStudent = null;
            return;
        }
        Hogwarts maxRatioStudent = null;
        Hogwarts minRatioStudent = null;

        if (otherStudent.getCharacterRatio() > this.getCharacterRatio()) {
            maxRatioStudent = otherStudent;
            minRatioStudent = this;
        } else {
            maxRatioStudent = this;
            minRatioStudent = otherStudent;
        }
        if (maxRatioStudent.getCharacterRatio() != minRatioStudent.getCharacterRatio()) {
            System.out.println("\n"
                    + maxRatioStudent.getName()
                    + " (общая оценка качеств: "
                    + maxRatioStudent.getCharacterRatio()
                    + ") лучший "
                    + maxRatioStudent.getFacultyAffiliation()
                    + "ец, чем "
                    + minRatioStudent.getName()
                    + " (общая оценка качеств: "
                    + minRatioStudent.getCharacterRatio()
                    + ")"
            );
        } else {
            System.out.println("\nу "
                    + maxRatioStudent.getName()
                    + " и "
                    + minRatioStudent.getName()
                    + " \nодинаковое суммарное значение оценки качеств характера");
        }
        maxRatioStudent = null;
        minRatioStudent = null;
    }

    public String getFacultyAffiliation() {
        switch (this.getClass().getSimpleName()) {
            case "Gryffindor":
                return  "Гриффиндор";
            case "Hufflepuff":
                return  "Пуффендуй";
            case "Ravenclaw":
                return  "Когтевран";
            case "Slytherin":
                return  "Слизерин";
        }
        return null;
    }

    public int getTransgression() {
        return transgression;
    }

    public void setTransgression(int transgression) {
        course02.topic02.hw.Common.chkValuePositive(transgression);
        this.transgression = transgression;
    }

    @Override
    public String toString() {
        return this.name
                + " с факультета "
                + this.getFacultyAffiliation()
                + "\nТрансгрессия: " + getTransgression()
                + ", Колдовство: " + getSorcery();

    }
}
