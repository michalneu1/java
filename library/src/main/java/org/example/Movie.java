package org.example;

public class Movie extends LibraryItem {
    private static int counter = 0;
    private final String director;

    public Movie(String title, String director, int length) {
        super(title, length);
        this.director = director;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Movie{" + super.toString() + ", director=" + director + "}";
    }
}
