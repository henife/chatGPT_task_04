package day11_29;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "day11_29.Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Book[] bookShell = {
                new Book("Animal farm", "George Orwell",22.5),
                new Book("How to win friends and influnce people", "Dale Carnegie", 19.8),
                new Book("Iz", "Abdurihim Otkvr",35.8),
        };
        for(Book book : bookShell) {
            System.out.println(book.toString());
            System.out.println(book.isExpensive());
        }
    }
    public String isExpensive(){
        if(getPrice() > 20) {
            return ("The book is expensive");
        }
           return ("The book is affordable");
    }
}
