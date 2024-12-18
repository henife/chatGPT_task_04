package day11_30;

import java.util.Arrays;
import java.util.Scanner;

public class BookManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter how many books you would like to add: ");
        int numberOfBooks = scanner.nextInt();
        Book[] books = new Book[numberOfBooks];

        for (int i = 0; i < numberOfBooks; i++) {
            scanner.nextLine();
            System.out.println("Please enter the name of the book: ");
            String name = scanner.nextLine();
            System.out.println("Please enter the author of the book: ");
            String author = scanner.nextLine();
            System.out.println("Please enter how many pages the book is: ");
            int pages = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Please enter the published year of the book: ");
            int publicationYear = scanner.nextInt();
            scanner.nextLine();
            books[i] = new Book(name, author, pages, publicationYear);

        }
        System.out.println("\nbooks added: ");
        for (Book book : books) {
            System.out.println(book);
        }
        searchByTitle(books, scanner);
        sortByYear(books);
        scanner.close();
    }

    public static void searchByTitle(Book[] books, Scanner scanner) {
        System.out.println("Please enter the title of the book that you would like to search: ");
        String searchedTitle = scanner.nextLine().toLowerCase();
        System.out.println("Search results: ");
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchedTitle)) {
                System.out.println(book);
                found = true;
            }
            if (!found) {
                System.out.println("No books found with the title: " + searchedTitle);
            }
        }

    }

    public static void sortByYear(Book[] books) {
        System.out.println("do you want to sort the books by year? ");
        Scanner scanner = new Scanner(System.in);
        String userAnswer = scanner.nextLine().toLowerCase();
        int[] arrayOfYears = new int[books.length];
        if (userAnswer.equalsIgnoreCase("yes")) {
            for (int i = 0; i < books.length; i++) {
                for (int j = 0; j < books.length; j++) {
                    if (books[j].publicationYear > books[j + 1].publicationYear) {
                        Book temp = books[j];
                        books[j] = books[j + 1];
                        books[j + 1] = temp;
                    }
                }

            }
            System.out.println("\nBooks sorted by publication year:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
