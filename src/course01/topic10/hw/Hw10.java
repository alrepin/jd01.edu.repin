package course01.topic10.hw;
public class Hw10 {

    public static void main() {
        Author[] authors = new Author[2];

        for (int i = 0; i < authors.length; i++) {
            authors[i] = new Author("name" + (i + 1), "surname" + (i + 1));
            System.out.println("authors[" + i + "] = " + authors[i]);
        }

        for (int i = 0; i < authors.length; i++) {
            System.out.println("authors[" + i + "].hashCode() = " + authors[i].hashCode());
        }

        System.out.println("authors[0].equals(authors[1]) = " + authors[0].equals(authors[1]));

        authors[1].setName("name1");
        authors[1].setSurname("surname1");
        for (int i = 0; i < authors.length; i++) {
            System.out.println("authors[" + i + "] = " + authors[i]);
        }

        for (int i = 0; i < authors.length; i++) {
            System.out.println("authors[" + i + "].hashCode() = " + authors[i].hashCode());
        }
        System.out.println("authors[0].equals(authors[1]) = " + authors[0].equals(authors[1]));

        Book[] books = new Book[2];

        for (int i = 0; i < books.length; i++) {
            books[i] = new Book("Книга " + (i + 1), authors[i], 2000 + i);
            System.out.println("books[" + i + "] = " + books[i]);
            System.out.println("books[" + i + "].hashCode() = " + books[i].hashCode());
        }
        System.out.println("books[0].equals(books[1]) = " + books[0].equals(books[1]));
        books[1].setYear(2000);
        books[1].setName("Книга 1");
        for (int i = 0; i < books.length; i++) {
            System.out.println("books[" + i + "] = " + books[i]);
            System.out.println("books[" + i + "].hashCode() = " + books[i].hashCode());
        }
        System.out.println("books[0].equals(books[1]) = " + books[0].equals(books[1]));

    }
}
