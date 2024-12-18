package day11_29;

public class Book2 {
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;

    public Book2(String title, String author, int year, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
    public boolean borrowBook() {
        if(isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "day11_29.Book2{" +
                "title='" + title + '\n' +
                "author='" + author + '\n' +
                "year=" + year +
                "\nisAvailable=" + isAvailable +
                '}';
    }

}
