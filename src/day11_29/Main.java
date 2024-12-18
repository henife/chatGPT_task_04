package day11_29;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner information = new Scanner(System.in);
            System.out.println("Please enter the name of the book");
            String title = information.nextLine();
            System.out.println("Please enter the author of the book");
            String author = information.nextLine();
            System.out.println("Please enter the genre of the book");

            String genre = "";
            boolean validGenre = false;
            while (!validGenre) {
                System.out.println("Enter the genre (Fiction, Non-Fiction, Fantasy, Science Fiction, Biography):");
                genre = information.nextLine().trim();

                // Control flow to check valid genres
                if (genre.equalsIgnoreCase("Fiction") || genre.equalsIgnoreCase("Non-Fiction") ||
                        genre.equalsIgnoreCase("Fantasy") || genre.equalsIgnoreCase("Science Fiction") ||
                        genre.equalsIgnoreCase("Biography")) {
                    validGenre = true;
                } else {
                    System.out.println("Invalid genre. Please enter a valid genre.");
                }
            }

Book3 book3 = new Book3(title,author,genre);
            book3.display();
        System.out.println(book3.getGenreMessage());
        information.close();
        }
    }