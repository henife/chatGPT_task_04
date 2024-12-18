package day11_29;

public class Library {
    private Book[] books;
    private int bookCount;

    public Library(int size) {
        books = new Book[size];
    }

    public static void main(String[] args) {

    }
    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
        }
        else {
            System.out.println("day11_29.Library is full, cannot add more books.");
        }
    }

    public void listAvailableBooks(){
    }
    public void borrowedBook(String title){

    }
    public void returnedBook(String title){

    }
}
