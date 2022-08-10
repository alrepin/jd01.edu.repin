package course01.topic10.hw;

import java.util.Objects;

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

    public String getSurname(){
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Автор: " + this.name + " " + this.surname;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Author a2 = (Author) other;
        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        return this.toString().equals(a2.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }
}