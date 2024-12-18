package day11_30;

import java.util.Arrays;
import java.util.Scanner;

public class Student {

    public String name;
    public double[] grade;
    double scoreSum;
    double average;

    public Student(String name, int lengthOfGrade) {
        this.name = name;
        this.grade = new double[lengthOfGrade];
    }

    public void setGrade(Scanner scanner) {
        System.out.println("please enter " + name + "'s grade: ");
        for (int i = 0; i < grade.length; i++) {
            grade[i] = scanner.nextDouble();
        }
    }

    public String getName() {
        return name;
    }

    public String formattedName() {
        String[] nameParts = name.split(" "); // Split by space to handle multi-word names
        StringBuilder formattedName = new StringBuilder();
        for (String part : nameParts) {
            formattedName.append(part.substring(0, 1).toUpperCase()) // Capitalize first letter
                    .append(part.substring(1).toLowerCase()) // Lowercase the rest
                    .append(" ");
        }
        return formattedName.toString().trim();
    }
    public void displayStudent(){
        System.out.println("Student Name: " + formattedName());
        System.out.print("Grades: ");
        for (double grades : grade) {
            System.out.print(grades + " ");
        }
        System.out.println(String.format("\nAverage Grade: " + getAverage()));
    }

    public double getAverage() {
        for (int i = 0; i < grade.length; i++) {
            scoreSum += grade[i];
        }
        average = scoreSum / grade.length;
        return average;
    }
}
