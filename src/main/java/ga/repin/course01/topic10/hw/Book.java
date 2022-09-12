package ga.repin.course01.topic10.hw;
import java.util.Objects;

public class Book {
    private final String name;
    private final Author author;
    private int year;

    public Book(String name, Author author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName(){
        return this.name;
    }

    public Author getAuthor(){
        return this.author;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
    }

    @Override
    public String toString() {
        return "Название: " + this.name + " г.и.: " + this.year + " " + this.getAuthor();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Book otherBook = (Book) other;
        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        return Objects.equals(this.name,otherBook.getName()) &&
                this.author.equals(otherBook.author);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.name, this.author.getName(), this.author.getSurname());
    }
}