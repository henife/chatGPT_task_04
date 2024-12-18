package day11_29;

public class Book3 {
    private String title;
    private String author;
    private String genre;

    public Book3(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
    public void display() {
        System.out.println("Title: " + title.toUpperCase() + "\nAuthor: " + author.toUpperCase() + "\nGenre: " + genre);
    }
    public String getGenreMessage() {
        switch (genre.toLowerCase()) {
            case "fiction":
                return "A gripping story awaits you!";
            case "non-fiction":
                return "Learn something new and insightful!";
            case "fantasy":
                return "Embark on a magical adventure!";
            case "science fiction":
                return "Explore the future of technology!";
            case "biography":
                return "Get inspired by real-life stories!";
            default:
                return "Unknown genre. Try again!";
        }
    }
}
