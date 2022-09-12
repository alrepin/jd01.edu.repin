package ga.repin.course02.topic02_2.hw;

public interface TrailerInstalled {
    default void checkTrailer() {
        System.out.println("Проверяем прицеп");
    }
}
