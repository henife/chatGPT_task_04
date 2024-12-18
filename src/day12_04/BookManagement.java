package day12_04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("Welcome to Book Management System!");
            System.out.println("Please select your options: ");
            System.out.println("1. View all books");
            System.out.println("2. Search book by title");
            System.out.println("3. Search book by author");
            System.out.println("4. Books published after certain years");
            System.out.println("5. Remove a book");
            System.out.println("6. Sort books by published year");
            System.out.println("7. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();

            books.add(new Book("Java Programming", "John Doe", 2015));
            books.add(new Book("Python for Beginners", "Jane Smith", 2018));
            books.add(new Book("Mastering Java", "John Doe", 2020));


            if (option == 1) {
                viewAllBooks(books);
            } else if (option == 2) {
                searchBookByTitle(books);
            } else if (option == 3) {
                searchBookByAuthor(books);
            } else if (option == 4) {
                searchBookByYear(books);
            } else if (option == 5) {
                removeBook(books);
            } else if (option == 6) {
                sortBooksByYear(books);
            } else if (option == 7) {
                System.exit(0);
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    public static void viewAllBooks(ArrayList<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println(Book.title + " is written by " + Book.author + " published " + Book.publicationYear + " year.");

    }

    public static void searchBookByTitle(ArrayList<Book> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the book title that you want to search: ");
        String searchedTitle = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Book book : books) {
            if (book.title.toLowerCase().contains(searchedTitle)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with that title.");
        }
    }

    public static void searchBookByAuthor(ArrayList<Book> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the book author that you want to search: ");
        String searchedAuthor = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Book book : books) {
            if (book.author.toLowerCase().contains(searchedAuthor)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with the author.");
        }
    }

    public static void searchBookByYear(ArrayList<Book> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the book year that you want to search: ");
        int searchedYear = scanner.nextInt();
        boolean found = false;
        for (Book book : books) {
            if (book.publicationYear >= searchedYear) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found published after that year.");
        }
    }
    public static void removeBook(ArrayList<Book> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the title of the book to remove:");
        String removeBook = scanner.nextLine().toLowerCase();

        Iterator<Book> iterator = books.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.title.toLowerCase().contains(removeBook)) {
                iterator.remove();  // Safely remove the book
                removed = true;
                System.out.println("Book removed: " + book);
                break;
            }
        }

        if (!removed) {
            System.out.println("No book found with that title.");
        }
    }

    // Sort books by publication year
    public static void sortBooksByYear(ArrayList<Book> books) {
        books.sort(Comparator.comparingInt(book -> book.publicationYear));
        System.out.println("Books sorted by publication year:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}