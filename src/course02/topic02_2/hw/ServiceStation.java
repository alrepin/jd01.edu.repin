package course02.topic02_2.hw;

public class ServiceStation {
    public void printCaption(Vehicle vehicle) {
            System.out.println("Обслуживаем " + vehicle.getModelName());
    }
    public void check(Car car) {
        printCaption(car);
        for (int i = 0; i < car.getWheelCount(); i++) {
            car.updateTyre();
        }
        car.checkEngine();
    }

    public void check(Bicycle bicycle) {
        printCaption(bicycle);
        for (int i = 0; i < bicycle.getWheelCount(); i++) {
            bicycle.updateTyre();
        }
    }

    public void check(Truck truck) {
        printCaption(truck);
        for (int i = 0; i < truck.getWheelCount(); i++) {
            truck.updateTyre();
        }
        truck.checkEngine();
        truck.checkTrailer();
    }
//just example
    public void check(Launch launch) {
        printCaption(launch);
        launch.checkEngine();
    }
}
