package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    static void task1() {
        System.out.println("Podaj wymiar a prostokata");
        int a = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj wymiar b prostokata");
        int b = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == 0 || i == a - 1 || j == b - 1 || j ==0) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    static void task2() {
        System.out.println("Podaj wysokosc piramidy");
        int a = scanner.nextInt();
        for (int i = 1; i <= a; i++) {

            for (int j = 1; j <= a - i; j++) {
                System.out.print(' ');
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.nextLine();
    }

    static void task3() {
        int[][] table = new int[3][3];
        int num = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = num++;
            }
        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }

    static void task4() {
        System.out.println("podaj hasło");
        String pass = scanner.nextLine();

        if (Main.isUnique(pass)) {
            System.out.println("Hasło jest unikalne");
        } else {
            System.out.println("Hasło nie jest unikalne");
        }
    }

    static boolean isUnique(String a) {
        for (int i = 0; i < a.length(); i++) {
            for (int j = i + 1; j < a.length(); j++) {
                if (a.charAt(i) == a.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}