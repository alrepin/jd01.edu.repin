package ga.repin.education.course02.topic02_2.hw;

public class Truck extends Vehicle implements TiresInstalled, EngineInstalled, TrailerInstalled {
    public Truck(String modelName, int wheelCount) {
        super(modelName, wheelCount);
    }

    @Override
    public void check() {
        this.printCaption();
        this.updateTyre(this);
        this.checkEngine();
        this.checkTrailer();
    }
}
