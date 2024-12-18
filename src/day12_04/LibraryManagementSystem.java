package day12_04;

import java.util.ArrayList;
import java.util.Scanner;

class BookToday {
    String title;
    String author;
    String isbn;
    int copies;

    public BookToday(String title, String author, String isbn, int copies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies = copies;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", copies=" + copies +
                '}';
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BookToday> books = new ArrayList<>();
        while (true) {
            System.out.println("""
                    *****  Welcome to Library Management System! make your choice: *****
                    1. Add a Book.
                    2. Update Book Information.
                    3. View All Books.
                    4. Search for a Book.
                    5. Check Out a Book.
                    6. Return a Book.
                    7. Remove a Book.
                    8. Exit.
                    """
            );
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addBook(books);
                case 2 -> updateBook(books);
                case 3 -> viewAll(books);
                case 4 -> searchBook(books);
                case 5 -> checkout(books);
                case 6 -> returnBook(books);
                case 7 -> removeBook(books);
                case 8 -> {
                    System.out.println("Exiting the program");
                    return;
                }
                default -> System.out.println("Invalid input!!! Please enter again! ");
            }
        }
    }

    public static void addBook(ArrayList<BookToday> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title: ");
        String title = scanner.nextLine();
        System.out.println("Please enter the author: ");
        String author = scanner.nextLine();
        System.out.println("Please enter the ISBN: ");
        String isbn = scanner.nextLine();
        System.out.println("Please enter the copies: ");
        int copies = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Book added");
        books.add(new BookToday(title, author, isbn, copies));
    }

    public static void updateBook(ArrayList<BookToday> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title or ISBN of the book that you would like to update: ");
        String selectedTitle = scanner.nextLine();

        boolean found = false;
        for (BookToday book : books) {
            if (book.getTitle().equalsIgnoreCase(selectedTitle) && book.getIsbn().equalsIgnoreCase(selectedTitle)) {
        System.out.println("What would you like to update?(title/author/copies)");
        String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("title")) {
                System.out.println("Enter the new title ");
                book.setTitle(scanner.nextLine());
                System.out.println("Title updated");
                break;
            }
                else if (choice.equalsIgnoreCase("author")) {
                System.out.println("Enter the new author");
                book.setAuthor(scanner.nextLine());
                System.out.println("Aitle updated");
                break;
                }
                if (choice.equalsIgnoreCase("copies")) {
                    System.out.println("please enter the new numbers of the copies ");
                    int NewCopies = scanner.nextInt();
                    book.setCopies(NewCopies);
                    System.out.println("Copies updated");
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book is not found");
        }
    }

    public static void viewAll(ArrayList<BookToday> books) {
        if (books.isEmpty()) {
            System.out.println("No books in the library!!!");
            return;
        }
        for (BookToday book : books) {
            System.out.println(book);
        }
    }

    public static void searchBook(ArrayList<BookToday> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title or isbn of the book: ");
        String searchTitle = scanner.nextLine();
        boolean found = false;
        for (BookToday book : books) {
            if (book.title.equalsIgnoreCase(searchTitle) || book.isbn.equalsIgnoreCase(searchTitle)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book is not found");
        }
    }

    public static void checkout(ArrayList<BookToday> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title or isbn of the book that you would like to checkout: ");
        String checkoutTitle = scanner.nextLine();
        boolean found = false;
        for (BookToday book : books) {
            if (book.title.equalsIgnoreCase(checkoutTitle) || book.isbn.equalsIgnoreCase(checkoutTitle)) {
                if(book.copies > 0) {
                book.setCopies(book.getCopies() - 1);
                System.out.println("The book has been checked out");
            }
                else {
                    System.out.println("Sorry! this book is out of stock.");
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book is not found");
        }
    }

    public static void returnBook(ArrayList<BookToday> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title or isbn of the book that you would like to return: ");
        String returnTitle = scanner.nextLine();
        boolean found = false;
        for (BookToday book : books) {
            if (book.title.equalsIgnoreCase(returnTitle) || book.isbn.equalsIgnoreCase(returnTitle)) {
                book.setCopies(book.getCopies() + 1);
                System.out.println("The book has been returned");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book is not found");
        }
    }

    public static void removeBook(ArrayList<BookToday> books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title or isbn of the book: ");
        String removeTitle = scanner.nextLine();
        books.removeIf(book -> book.title.equalsIgnoreCase(removeTitle) || book.isbn.equalsIgnoreCase(removeTitle));
        System.out.println("The book has been removed");
    }
}
