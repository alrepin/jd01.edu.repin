package ga.repin.education.common.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RndPersonKey {
    private String name;
    private String surname;

    private String callingClass;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCallingClass() {
        return callingClass;
    }

    private static final String[] arrName = {"Петр", "Иван", "Василий", "Сидор", "Евгений", "Федор", "Анатолий", "Аркадий", "Игорь", "Андрей", "Александр"};
    private static final String[] arrSurname = {"Петров", "Иванов", "Пупкин", "Сидоров", "Пушкин", "Федоров", "Сергеев", "Романов", "Толстой"};

    public static List<RndPersonKey> usedFI = new ArrayList<>();

    public RndPersonKey(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public RndPersonKey() {
        this.name = randomName();
        this.surname = randomSurname();
    }

    public RndPersonKey(String callingClass) {
        this.callingClass = callingClass;
        if (getAvailableQuantity()<10) {
                usedFI.removeIf(e -> e.getCallingClass().equals(this.callingClass));
            }
            int initSize = usedFI.size();
            RndPersonKey tmp = new RndPersonKey();
            while (usedFI.size() == initSize) {
                tmp.name = randomName();
                tmp.surname = randomSurname();
                tmp.callingClass = callingClass;
                if (!usedFI.contains(tmp)) {
                    usedFI.add(tmp);
                }
            }
        this.name = tmp.name;
        this.surname = tmp.surname;

    }

    public int getFullQuantity() {
        return arrName.length * arrSurname.length;
    }

    public int getAvailableQuantity() {
        return getFullQuantity() - (int) usedFI.stream()
                .filter(e -> e.getCallingClass().equals(this.callingClass))
                .count();
    }

    public static String randomName() {

        java.util.Random random = new java.util.Random();
        return arrName[random.nextInt(arrName.length-1) + 1];
    }

    public static String randomSurname() {
        java.util.Random random = new java.util.Random();
        return arrSurname[random.nextInt(arrSurname.length-1) + 1];
    }

    @Override
    public String toString() {
        return "RndPersonKey{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", callingClass='" + callingClass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RndPersonKey that = (RndPersonKey) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(callingClass, that.callingClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, callingClass);
    }
}
