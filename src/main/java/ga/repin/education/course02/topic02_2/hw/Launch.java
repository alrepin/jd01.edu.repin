package ga.repin.education.course02.topic02_2.hw;

public class Launch extends Vehicle implements EngineInstalled{
    public Launch(String modelName) {
        super(modelName);
    }

    @Override
    public void check() {
        this.printCaption();
        this.checkEngine();
    }
}
