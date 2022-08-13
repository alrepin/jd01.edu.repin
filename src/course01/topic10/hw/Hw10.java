package course01.topic10.hw;
public class Hw10 {

    public static void main() {
        Author[] authors = new Author[2];

        for (int i = 0; i < authors.length; i++) {
            authors[i] = new Author(creation.Common.randomName(), creation.Common.randomSurname());
            System.out.println("authors[" + i + "] = " + authors[i]);
        }

        System.out.println("authors[0].equals(authors[1]) = " + authors[0].equals(authors[1]));

        Book[] books = new Book[2];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book("\"" + (creation.Common.randomBookName()) + "\"", authors[i], 2000 + i);
            System.out.println("books[" + i + "] = " + books[i]);
        }
        System.out.println("books[0].equals(books[1]) = " + books[0].equals(books[1]));
    }
}
