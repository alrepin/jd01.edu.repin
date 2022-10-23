package ga.repin.education.course01.topic09.hw;
public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName(){
        return this.name;
    }

    public String getSurename(){
        return this.surname;
    }
}
