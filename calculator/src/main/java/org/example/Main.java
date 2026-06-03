package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double lastResult;

        while (true) {
            System.out.println("Podaj działanie w formacie: liczba operator liczba (np. 2 + 3, 22 / 4)");
            String line = reader.readLine();
            if (line == null) {
                System.out.println("Brak danych wejściowych. Spróbuj ponownie.");
                continue;
            }

            String[] tokens = line.trim().split("\\s+");
            if (tokens.length != 3) {
                System.out.println("Niepoprawny format. Oczekiwano trzech elementów oddzielonych spacjami, otrzymano "
                        + tokens.length + ". Przykład: 2 + 3");
                continue;
            }

            if (!isNumber(tokens[0])) {
                System.out.println("Pierwsza wartość '" + tokens[0] + "' nie jest liczbą.");
                continue;
            }
            if (!isNumber(tokens[2])) {
                System.out.println("Druga wartość '" + tokens[2] + "' nie jest liczbą.");
                continue;
            }
            if (tokens[1].length() != 1 || !"+-*/%^".contains(tokens[1])) {
                System.out.println("Nieznany operator '" + tokens[1] + "'. Dozwolone: + - * / % ^");
                continue;
            }

            double inputA = Double.parseDouble(tokens[0]);
            double inputB = Double.parseDouble(tokens[2]);
            char sign = tokens[1].charAt(0);

            if ((sign == '/' || sign == '%') && inputB == 0) {
                System.out.println("Nie można dzielić przez zero. Podaj inne działanie.");
                continue;
            }

            Double result = switch (sign) {
                case '+' -> inputA + inputB;
                case '-' -> inputA - inputB;
                case '*' -> inputA * inputB;
                case '/' -> inputA / inputB;
                case '%' -> inputA % inputB;
                case '^' -> Math.pow(inputA, inputB);
                default -> null;
            };

            System.out.println("wynik: " + result);
            lastResult = result;

            System.out.println("Czy wykonać kolejne działanie? y/n");
            String answer = reader.readLine();
            if (answer == null || answer.equalsIgnoreCase("n")) {
                System.out.println("koniec");
                break;
            }
        }

        String isPositive = lastResult >= 0
                ? "Ostatni wynik jest dodatni (lub zero)."
                : "Ostatni wynik jest ujemny.";
        System.out.println(isPositive);


        String parity = (lastResult) % 2 == 0
                ? "Ostatni wynik jest parzysty."
                : "Ostatni wynik jest nieparzysty.";
        System.out.println(parity);

    }

//    private static boolean isNumber(String s) {
//        int i = 0;
//        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
//            i++;
//        }
//        if (i == s.length()) {
//            return false;
//        }
//        boolean hasDot = false;
//        boolean hasDigit = false;
//        for (; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == '.') {
//                if (hasDot) {
//                    return false;
//                }
//                hasDot = true;
//            } else if (Character.isDigit(c)) {
//                hasDigit = true;
//            } else {
//                return false;
//            }
//        }
//        return hasDigit;
//    }

    private static boolean isNumber(String s){
        return s.matches("-?\\d+(\\.\\d+)?");
    }
}