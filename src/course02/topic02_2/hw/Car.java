package course02.topic02_2.hw;

public class Car extends Vehicle implements TiresInstalled, EngineInstalled {
    public Car(String modelName, int wheelCount) {
        super(modelName, wheelCount);
    }

    @Override
    public void check() {
        this.printCaption();
        this.updateTyre(this);
        this.checkEngine();
    }
}
