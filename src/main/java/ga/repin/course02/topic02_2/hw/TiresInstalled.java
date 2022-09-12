package ga.repin.course02.topic02_2.hw;

public interface TiresInstalled {
    default void updateTyre(Vehicle vehicle) {
        for (int i = 0; i < vehicle.getWheelCount(); i++) {
            System.out.println("Меняем покрышку");
        }
    }
}
