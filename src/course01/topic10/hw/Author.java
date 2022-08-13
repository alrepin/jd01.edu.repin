package course01.topic10.hw;
import java.util.Objects;

public class Author {
    private final String name;
    private final String surname;
    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    @Override
    public String toString() {
        return "Автор: " + this.name + " " + this.surname;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Author otherAuthor = (Author) other;
        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        return this.getName().equals(otherAuthor.getName()) && this.getSurname().equals(otherAuthor.getSurname());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.name, this.surname);
    }
}