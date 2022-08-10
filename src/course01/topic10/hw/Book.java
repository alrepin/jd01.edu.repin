package course01.topic10.hw;

import java.util.Objects;

public class Book {
    private String name;
    private Author author;
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

    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Название: " + this.name + " г.и.: " + this.year + " " + this.getAuthor();
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Book b2 = (Book) other;
        if (this.hashCode() != other.hashCode()) {
            return false;
        }
        return this.toString().equals(b2.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }
}