package org.example;

import org.example.generator.EmployeeGenerator;
import org.example.generator.HoldingGenerator;
import org.example.model.*;
import org.example.model.Currency;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Exercises {

    private static final List<Holding> holdings = new HoldingGenerator().generate();
    private static final List<Employee> employee = new EmployeeGenerator().generate();


    public static void main(String[] args) {
        System.out.println(Exercises.getHoldingNamesAsString());
        Exercises.showAllUser();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);
        Predicate<Integer> predicate = integer -> integer % 2 != 0;
        Exercises.isNotEven(numbers,predicate);
        Function<String, String> trim = String::trim;
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> trimThenUpper = trim.andThen(toUpper);
        String input = "   hello world   ";
        System.out.println(trimThenUpper.apply(input));
        Exercises.exercise8();
        List<String> sentences = Arrays.asList("hello world", "java streams", "world of code");
        System.out.println(Exercises.exercise9(sentences));

    }

    /**
     * Napisz metodę, która zwróci liczbę holdingów, w których jest przynajmniej jedna firma.
     */
    public static long getHoldingsWhereAreCompanies() {

        return holdings.stream().filter(holding -> !holding.getCompanies().isEmpty()).count();
    }

    /**
     * Napisz metodę, która zwróci nazwy wszystkich holdingów pisane z wielkiej litery w formie listy.
     */
    public static List<String> getHoldingNames() {

        return holdings.stream().map(holding -> {
            String name = holding.getName();
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }).collect(Collectors.toList());
    }

    /**
     * Zwraca nazwy wszystkich holdingów sklejone w jeden string i posortowane.
     * String ma postać: (Coca-Cola, Nestle, Pepsico)
     */
    public static String getHoldingNamesAsString() {

        return holdings.stream().map(Holding::getName).sorted().collect(Collectors.joining(", ","(",")"));
    }

    /**
     * Zwraca liczbę firm we wszystkich holdingach.
     */
    public static long getCompaniesAmount() {

        return holdings.stream().mapToLong(holding -> holding.getCompanies().size()).sum();
    }


    /**
     * Zwraca liczbę wszystkich pracowników we wszystkich firmach.
     */
    public static long getAllUserAmount() {

        return Exercises.getCompanyStream().mapToLong(company -> company.getUsers().size()).sum();
    }

    /**
     * Zwraca listę wszystkich firm jako listę, której implementacja to LinkedList. Obiektów nie przepisujemy
     * po zakończeniu działania strumienia.
     */
    public static LinkedList<String> getAllCompaniesNamesAsLinkedList() {

        return Exercises.getCompanyStream().map(Company::getName).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Przelicza kwotę na rachunku na złotówki za pomocą kursu określonego w enum Currency.
     */
    public static BigDecimal getAccountAmountInPLN(Account account) {
        return account
                .getAmount().multiply(BigDecimal.valueOf(account.getCurrency().rate))
                .round(new MathContext(4, RoundingMode.HALF_UP));
    }

    /**
     * Zwraca imiona użytkowników w formie zbioru, którzy spełniają podany warunek.
     */
    public static Set<String> getUsersForPredicate(final Predicate<User> userPredicate) {
        return getUserStream().filter(userPredicate)
                .map(User::getFirstName).collect(Collectors.toSet());
    }

    /**
     * Dla każdej firmy uruchamia przekazaną metodę.
     */
    public static void executeForEachCompany(Consumer<Company> consumer) {
        Exercises.getCompanyStream().forEach(consumer);
    }

    /**
     * Wyszukuje najbogatsza kobietę i zwraca ją. Metoda musi uzwględniać to że rachunki są w różnych walutach.
     */
    //pomoc w rozwiązaniu problemu w zadaniu: https://stackoverflow.com/a/55052733/9360524
    public static Optional<User> getRichestWoman() {
        return Exercises.getUserStream().filter(user -> user.getSex() == Sex.WOMAN)
                .max(Comparator.comparing(Exercises::getUserAmountInPLN));
    }

    private static BigDecimal getUserAmountInPLN(final User user) {
        return user.getAccounts().stream()
                .map(Exercises::getAccountAmountInPLN)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Zwraca nazwy pierwszych N firm. Kolejność nie ma znaczenia.
     */
    private static Set<String> getFirstNCompany(final int n) {

        return Exercises.getCompanyStream().limit(n).map(Company::getName).collect(Collectors.toSet());
    }

    /**
     * Zwraca mapę firm, gdzie kluczem jest jej nazwa a wartością lista pracowników.
     */
    public static Map<String, List<User>> getUserPerCompany() {

        return Exercises.getCompanyStream().collect(Collectors
                .toMap(Company::getName, Company::getUsers, (a, b) -> a));
    }

    /**
     * Zwraca pierwszego z brzegu użytkownika dla podanego warunku. W przypadku kiedy nie znajdzie użytkownika, wyrzuca
     * wyjątek IllegalArgumentException.
     */
    public static User getUser(final Predicate<User> predicate) {
        return Exercises.getUserStream().filter(predicate).findAny().orElseThrow(() -> new IllegalArgumentException("Nie znaleziono użytkownika"));
    }

    /**
     * Zwraca mapę rachunków, gdzie kluczem jest numer rachunku, a wartością ten rachunek.
     */
    public static Map<String, Account> createAccountsMap() {

        return Exercises.getAccoutStream().collect(Collectors.toMap(Account::getNumber, account -> account, (a, b) -> a));
    }

    /**
     * Zwraca listę wszystkich imion w postaci Stringa, gdzie imiona oddzielone są spacją i nie zawierają powtórzeń.
     */
    public static String getUserNames() {

        return Exercises.getUserStream().map(User::getFirstName).distinct().collect(Collectors.joining(" "));
    }

    /**
     * Metoda wypisuje na ekranie wszystkich użytkowników (imię, nazwisko) posortowanych od z do a.
     * Zosia Psikuta, Zenon Kucowski, Zenek Jawowy ... Alfred Pasibrzuch, Adam Wojcik
     */
    public static void showAllUser() {
        Exercises.getUserStream().map(user -> String.format("%s %s, ", user.getFirstName(), user.getLastName()))
                .sorted(Comparator.reverseOrder()).forEach(System.out::print);
    }

    /**
     * Zwraca zbiór walut w jakich są rachunki.
     */
    public static Set<Currency> getCurenciesSet() {
        return Exercises.getAccoutStream().map(Account::getCurrency).collect(Collectors.toSet());
    }

    /**
     * Zwraca strumień wszystkich firm.
     */
    private static Stream<Company> getCompanyStream() {
        return holdings.stream().flatMap(holding -> holding.getCompanies().stream());
    }

    /**
     * Tworzy strumień użytkowników.
     */
    private static Stream<User> getUserStream() {
        return getCompanyStream().flatMap(company -> company.getUsers().stream());
    }

    /**
     * Tworzy strumień rachunków.
     */
    private static Stream<Account> getAccoutStream() {
        return getUserStream().flatMap(user -> user.getAccounts().stream());
    }

    //    Masz listę liczb całkowitych: List<Integer> numbers = Arrays.asList(1, 2, 3, 10, 15, 20);
//    Napisz metodę, która przyjmuje listę i Predicate<Integer> i zwraca nową listę zawierającą tylko te elementy, które spełniają warunek predykatu.
//
//    Utwórz lambdę sprawdzającą, czy liczba jest parzysta i wywołaj metodę, aby odfiltrować tylko parzyste liczby.
//    Wypisz wynik na konsolę.
//
//    Zdefiniuj dwie funkcje Function<String, String>:
//    Jedna usuwa białe spacje z początku i końca napisu (trim),
//    Druga zamienia wszystkie litery na wielkie (toUpperCase).
//    Użyj metod andThen lub compose aby połączyć te funkcje w jedną całość i zastosuj ją do ciągu znaków z niechcianymi spacjami i małymi literami (np. " hello world ").

    private static void isNotEven(List<Integer> list,Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }

    private static void exercise8() {
        employee.stream().filter(employee -> employee.getAge() < 26).sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors
                        .mapping(Employee::toString, Collectors.joining(", "))))
                .forEach((department, data) -> System.out.printf("%s: {%s}%n", department, data));
    }

    private static String exercise9(List<String> list) {
        return list.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toCollection(TreeSet::new))
                .stream().collect(Collectors.joining(","));
    }

}
