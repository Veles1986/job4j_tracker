package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("The Adventures of Paddington", 300);
        Book secondBook = new Book("Captain Daredevil", 250);
        Book thirdBook = new Book("The Catcher in the Rye", 350);
        Book fourthBook = new Book("War and Peace", 1200);
        Book[] books = {firstBook, secondBook, thirdBook, fourthBook};
        books[1].setName("Clean Code");
        System.out.println("List of books:");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Name of book " + (i + 1) + ": " + books[i].getName() + System.lineSeparator()
                                + "Number of pages: " + books[i].getNumberOfPages());
        }
        Book helpBook = books[0];
        books[0] = books[3];
        books[3] = helpBook;
        System.out.println("\nList of books after change");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Name of book " + (i + 1) + ": " + books[i].getName() + System.lineSeparator()
                    + "Number of pages: " + books[i].getNumberOfPages());
        }
        System.out.println("\nBooks with name \"Clean Code\":");
        for (int i = 0; i < books.length; i++) {
            if ("Clean Code".equals(books[i].getName())) {
                System.out.println("Name of book " + (i + 1) + ": " + books[i].getName() + System.lineSeparator()
                        + "Number of pages: " + books[i].getNumberOfPages());
            }
        }
    }
}
