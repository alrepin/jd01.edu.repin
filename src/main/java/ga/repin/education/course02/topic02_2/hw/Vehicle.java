package ga.repin.education.course02.topic02_2.hw;

public abstract class Vehicle {
    private String modelName;
    private int wheelCount;

    //Overloaded constructor - if we will want to add new
    //children class which not implements to TiresInstalled
    public Vehicle(String modelName, int wheelCount) {
        this.modelName = modelName;
        this.wheelCount = wheelCount;
    }
    public Vehicle(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public void printCaption() {
        System.out.println("Обслуживаем " + this.getModelName());
    }

    abstract void check();
}
