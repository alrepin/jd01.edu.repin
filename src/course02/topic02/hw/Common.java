package course02.topic02.hw;

public class Common {
    public static void chkValueIn0_100interval(int value) {
        if (value<0 || value>100) {
            throw new IllegalArgumentException("Неверное значение параметра: " +  value
                    + ", \nсвойства оцениваются в целочисленном эквиваленте от 0 до 100");
        }
    }

    public static void chkCharacterValueIn0_100interval(Character character, String studName) {
        if (character.getValue()<0 || character.getValue()>100) {
            throw new IllegalArgumentException("\nНеверное значение параметра "
                    + character.getName() + ": " +  character.getValue()
                    + "\nдля студента: " + studName + ", \nсвойства оцениваются в целочисленном эквиваленте от 0 до 100");
        }
    }

    public static void chkValuePositive(int value) {
        if (value<0) {
            throw new IllegalArgumentException("свойства оцениваются в целочисленном эквиваленте от 0 до 100");
        }
    }

    public static Hogwarts getStudByName(Hogwarts[] hogwartsStudents, String name) {
        for (int i = 0; i < hogwartsStudents.length; i++) {
            if (hogwartsStudents[i].getName() == name) {
                return hogwartsStudents[i];
            }
        }
        return null;
    }

}
