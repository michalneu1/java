package org.example;

public class Book extends LibraryItem {
    private static int counter = 0;
    private final String author;

    public Book(String title, String author, int length) {
        super(title, length);
        this.author = author;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() + ", author=" + author + "}";
    }
}
