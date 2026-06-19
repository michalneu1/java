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

    public void lendItem() {
        if (isBorrowed) {
            throw new ItemAlreadyBorrowedException(String.format("Tytuł '%s' został już wypożyczony", title));
        }
        isBorrowed = true;
        System.out.println("wypożyczono " + title);
    }

    public void returnItem() throws ItemAlreadyReturnedException {
        if (!isBorrowed) {
            throw new ItemAlreadyReturnedException(String.format("Item '%s' nie był wypożyczony", title));
        }
        isBorrowed = false;
        System.out.println("Zwrocono " + title);
    }

    @Override
    public String toString() {
        return "title='" + title + "', length=" + length + ", borrowed=" + isBorrowed;
    }
}
