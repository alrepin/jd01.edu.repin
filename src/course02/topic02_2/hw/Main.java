package course02.topic02_2.hw;

public class Main {
    public static void main() {
        Car car = new Car("car1", 4);
        Car car2 = new Car("car2", 4);
        Bicycle bicycle = new Bicycle("bicycle1", 2);
        Bicycle bicycle2 = new Bicycle("bicycle2", 2);
        Truck truck = new Truck("truck1", 6);
        Truck truck2 = new Truck("truck2", 8);
        //just example
        Launch launch = new Launch("launch1");

        ServiceStation station = new ServiceStation();
        station.check(car);
        station.check(car2);
        station.check(bicycle);
        station.check(bicycle2);
        station.check(truck);
        station.check(truck2);
        //just example
        station.check(launch);
    }
}
