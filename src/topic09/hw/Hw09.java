package topic09.hw;

public class Hw09 {
    public static void hwCaption() {
        System.out.println("Домашнее задание по уроку \"Объекты и классы\"");
    }

    public static void main() {
        hwCaption();
        Author[] authors = new Author[2];
        for (int i = 0; i < authors.length; i++) {
            authors[i] = new Author("name" + (i + 1), "surname" + (i + 1));
            System.out.println("Имя автора: " + authors[i].getName() + ", Фамилия автора: " + authors[i].getSurename());
        }

        Book[] books = new Book[2];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book("Книга " + (i + 1), authors[i], 2000 + i);
            System.out.println("Книга: " + books[i].getName() + ", " + books[i].getYear() + " г.и., автор: "
                    + books[i].getAuthor().getName() + " " + books[i].getAuthor().getSurename());
        }

        books[1].setYear(1982);

        System.out.println("books[1].getYear() = " + books[1].getYear());
    }
}
