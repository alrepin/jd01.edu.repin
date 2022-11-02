import ga.repin.education.course02.topic14.hw.StringList.*;
import ga.repin.education.course02.topic15.hw.IntegerList.*;

public class Main {
    public static void main(String[] args) {

        StringList stringList = new StringListImpl(5);
        for (int j = 0; j < 10; j++) {
            stringList.add("item" + j);

        }

        stringList.remove("item0");

        IntegerList integerList = new IntegerListImpl(5);
        for (int j = 0; j < 10; j++) {
            integerList.add(j);

        }

        integerList.remove((Integer) 0);

        for (int i = 0; i < integerList.size(); i++) {
            System.out.println(integerList.get(i));
            System.out.println(stringList.get(i));
        }
        System.out.println("integerList.size() = " + integerList.size());
        System.out.println("stringList.size() = " + stringList.size());
    }

}