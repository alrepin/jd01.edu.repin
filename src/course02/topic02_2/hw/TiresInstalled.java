package course02.topic02_2.hw;

public interface TiresInstalled {
    default void updateTyre() {
        System.out.println("Меняем покрышку");
    }
}
