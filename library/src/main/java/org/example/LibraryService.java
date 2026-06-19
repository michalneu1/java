package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

class LibraryService {
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<LibraryItem> elementsInLibrary = new ArrayList<>();

    public void handleLibrary() {
        boolean carryOn = true;
        while (carryOn) {
            printMenu();
            carryOn = handleChoice();
        }
    }

    private void printMenu() {
        System.out.println("""
                
                1: wyświetl listę elementów
                2: Wypożycz przedmiot
                3: zwróć element
                4: sprawdź liczbę książek i filmów
                5: wyjdź
                """);
    }

    private boolean handleChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return executeChoice(choice);
        } catch (ItemNotFoundException | ItemAlreadyBorrowedException | ItemAlreadyReturnedException e) {
            System.out.println("Błąd: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Wpisz cyfrę z menu (1-5).");
            scanner.nextLine();
        }
        return true;
    }

    private boolean executeChoice(int choice) throws ItemAlreadyReturnedException {
        switch (choice) {
            case 1 -> displayElements();
            case 2 -> findByTitle(readTitle())
                    .orElseThrow(() -> new ItemNotFoundException("Brak elementu o podanym tytule"))
                    .lendItem();
            case 3 -> findByTitle(readTitle())
                    .orElseThrow(() -> new ItemNotFoundException("Brak elementu o tym tytule"))
                    .returnItem();
            case 4 -> moviesAndBooksCount();
            case 5 -> {
                return false;
            }
            default -> System.out.println("Niepoprawny wybór, spróbuj ponownie.");
        }
        return true;
    }

    private String readTitle() {
        System.out.println("Podaj tytuł");
        return scanner.nextLine();
    }

    private Optional<LibraryItem> findByTitle(String title) {
        for (LibraryItem libraryItem : elementsInLibrary) {
            if (libraryItem.getTitle().equals(title)) {
                return Optional.of(libraryItem);
            }
        }
        return Optional.empty();
    }

    public void addElement(LibraryItem item) {
        elementsInLibrary.add(item);
    }

    public void displayElements() {
        for (LibraryItem libraryItem : elementsInLibrary) {
            System.out.println(libraryItem);
        }
    }

    public void moviesAndBooksCount() {
        System.out.printf("Ilość książek: %d %nilość filmów: %d %n", Book.getCounter(), Movie.getCounter());
    }
}