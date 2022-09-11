package course02.topic02_2.hw;

public class Bicycle extends Vehicle implements TiresInstalled {
    public Bicycle(String modelName, int wheelCount) {
        super(modelName, wheelCount);
    }

    @Override
    public void check() {
        this.printCaption();
        this.updateTyre(this);
    }
}
