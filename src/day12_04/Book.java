package day12_04;

import java.util.ArrayList;
import java.util.Arrays;

public class Book {
    public static String title;
    public static String author;
    public static int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public static void main(String[] args) {
        ArrayList<String> planets = new ArrayList<>(Arrays.asList("Earth", "Maris", "Jupiter", "Saturn", "Uranus"));
        planets.forEach(p -> System.out.println(p + "-" + p.toUpperCase()));
    }
}
