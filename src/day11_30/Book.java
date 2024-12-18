package day11_30;

public class Book {

    public String title;
    public String author;
    public int pages;
    public int publicationYear;

    public Book(String title, String author, int pages, int publicationYear) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String formatTitle() {
        String[] words = title.split(" ");
        StringBuilder formattedTitle = new StringBuilder();
        for(String word : words) {
            formattedTitle.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return formattedTitle.toString().trim();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + formatTitle()  + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
