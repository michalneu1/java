package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class LibraryService {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<LibraryItem> elementsInLibrary = new ArrayList<>();

    public static void handleLibrary() {
        boolean carryOn = true;
        while (carryOn) {
            System.out.println("""

                    1: wyświetl listę elementów
                    2: Wypożycz przedmiot
                    3: zwróć element
                    4: sprawdź liczbę książek i filmów
                    5: wyjdź
                    """);
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> displayElements();
                    case 2 -> {
                        System.out.println("Podaj tytuł");
                        String title = scanner.nextLine();
                        lendItem(title);
                    }
                    case 3 -> {
                        System.out.println("Podaj tytuł");
                        String title = scanner.nextLine();
                        returnElement(title);
                    }
                    case 4 -> moviesAndBooksCount();
                    case 5 -> carryOn = false;
                    default -> System.out.println("Niepoprawny wybór, spróbuj ponownie.");
                }
            } catch (ItemNotFoundException | ItemAlreadyBorrowedException | ItemAlreadyReturnedException e) {
                System.out.println("Błąd: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Wpisz cyfrę z menu (1-5).");
                scanner.nextLine();
            }
        }
    }

    public static void addElement(LibraryItem item) {
        elementsInLibrary.add(item);
    }

    public static void displayElements() {
        for (LibraryItem libraryItem : elementsInLibrary) {
            System.out.println(libraryItem);
        }
    }

    public static void lendItem(String title) {
        for (LibraryItem libraryItem : elementsInLibrary) {
            if (libraryItem.getTitle().equals(title)) {
                if (libraryItem.getIsBorrowed()) {
                    libraryItem.setBorrowed(true);
                    System.out.println("wypożyczono element");
                    return;
                } else {
                    throw new ItemAlreadyBorrowedException("Tytuł '" + title + "' został już wypożyczony");
                }
            }
        }
        throw new ItemNotFoundException("Brak elementu o tytule: " + title);
    }

    public static void returnElement(String title) throws ItemAlreadyReturnedException {
        for (LibraryItem libraryItem : elementsInLibrary) {
            if (libraryItem.getTitle().equals(title)) {
                if (libraryItem.getIsBorrowed()) {
                    throw new ItemAlreadyReturnedException("Element '" + title + "' nie był wypożyczony");
                }
                libraryItem.setBorrowed(false);
                System.out.println("Zwrocono " + title);
                return;
            }
        }
        throw new ItemNotFoundException("Brak elementu o tytule: " + title);
    }

    public static void moviesAndBooksCount() {
        System.out.printf("Ilość książek: %d %nilość filmów: %d %n", Book.getCounter(), Movie.getCounter());
    }
}
