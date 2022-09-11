package course02.topic02.lesson;

public class Gamer extends Person{
    private String platform;

    public Gamer(String name, int age, int phoneNumber, String platform) {
        super(name, age, phoneNumber);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
