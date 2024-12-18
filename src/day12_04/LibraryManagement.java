package day12_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class BookNew {
    private String title;
    private String author;
    private double price;
    private int quantity;

    public BookNew(String title, String author, double price, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BookNew{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BookNew> booksToday = new ArrayList<>();

        while (true) {
            System.out.println("""
                    Welcome to the Library Management System! please choose your intent: 
                    1. Add a new book to the library.
                    2. Update the price of an existing book.
                    3. View all books in the library.
                    4. Search for a book by its title.
                    5. Calculate the total value of all books in the library.
                    6. Sort by price.
                    7. Remove a book from the library.
                    8. Exit the program.
                    """);

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addBook(booksToday);
                case 2 -> updateBook(booksToday);
                case 3 -> viewBook(booksToday);
                case 4 -> searchBook(booksToday);
                case 5 -> calculateValue(booksToday);
                case 6 -> sortByPrice(booksToday);
                case 7 -> removeBooks(booksToday);
                case 8 -> {

                    System.out.println("System exiting");
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void addBook(ArrayList<BookNew> booksToday) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the title: ");
        String title = sc.nextLine();
        System.out.println("Please enter the author: ");
        String author = sc.nextLine();
        sc.nextLine();
        System.out.println("Please enter the price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Please enter the quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        BookNew bookNew = new BookNew(title, author, price, quantity);
        booksToday.add(bookNew);
    }

    public static void updateBook(ArrayList<BookNew> booksToday) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the title: ");
        String title = sc.nextLine();

        boolean found = false;
        for (BookNew bookNew : booksToday) {
            if (bookNew.getTitle().equalsIgnoreCase(title)) {
                System.out.println(bookNew.getTitle() + "'s current price is " + bookNew.getPrice());
                System.out.println("please enter the new price");
                double newPrice = sc.nextDouble();
                bookNew.setPrice(newPrice);
                System.out.println("Price has been updated");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book is not found");
        }
    }

    public static void viewBook(ArrayList<BookNew> booksToday) {
        if (booksToday.isEmpty()) {
            System.out.println("No books in the library");
        } else {
            for (BookNew bookNew : booksToday) {
                System.out.println(bookNew);
            }
        }
    }

    public static void searchBook(ArrayList<BookNew> booksToday) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the title: ");
        String title = sc.nextLine();

        boolean found = false;
        for (BookNew bookNew : booksToday) {
            if (bookNew.getTitle().equalsIgnoreCase(title)) {
                System.out.println(booksToday);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book is not found");
        }
    }

    public static void calculateValue(ArrayList<BookNew> booksToday) {
        double totalPrice = 0;
        for (BookNew bookNew : booksToday) {
            totalPrice += bookNew.getPrice() * bookNew.getQuantity();
        }
        System.out.println("This library worth: $" + totalPrice);
    }

    public static void sortByPrice(ArrayList<BookNew> booksToday) {
        booksToday.sort(Comparator.comparingDouble(BookNew::getPrice));
    }

    public static void removeBooks(ArrayList<BookNew> booksToday) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the title of the book you would like to remove: ");
        String title = sc.nextLine();

        boolean found = false;
        for (BookNew bookNew : booksToday) {
            if (bookNew.getTitle().equalsIgnoreCase(title)) {
                booksToday.remove(bookNew);
                System.out.println("The book has been removed");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book is not found");
        }
    }
}
