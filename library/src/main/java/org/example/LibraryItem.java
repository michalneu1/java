package org.example;

public abstract class LibraryItem {
    private final String title;
    private final int length;
    private boolean isBorrowed;

    public LibraryItem(String title, int length) {
        this.title = title;
        this.length = length;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    @Override
    public String toString() {
        return "title='" + title + "', length=" + length + ", borrowed=" + isBorrowed;
    }
}
