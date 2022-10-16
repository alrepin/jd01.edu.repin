package ga.repin.education.course01.topic10.hw;

import ga.repin.education.creation.Common;

public class Hw10 {

    public static void main() {
        Author[] authors = new Author[2];

        for (int i = 0; i < authors.length; i++) {
            authors[i] = new Author(Common.randomName(), Common.randomSurname());
            System.out.println("authors[" + i + "] = " + authors[i]);
        }

        System.out.println("authors[0].equals(authors[1]) = " + authors[0].equals(authors[1]));

        Book[] books = new Book[2];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book("\"" + (Common.randomBookName()) + "\"", authors[i], 2000 + i);
            System.out.println("books[" + i + "] = " + books[i]);
        }
        System.out.println("books[0].equals(books[1]) = " + books[0].equals(books[1]));
    }
}
