package day11_30;

import java.util.Scanner;

public class GradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of students: ");
        int numberOfStudent = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the number of subjects: ");
        int lengthOfGrade = scanner.nextInt();

        Student[] students = new Student[numberOfStudent];
for (int i = 0; i < numberOfStudent; i++) {
    scanner.nextLine();
    System.out.print("Enter the name of student " + (i + 1) + ": ");
    String name = scanner.nextLine();
    Student student = new Student(name,lengthOfGrade);
    student.setGrade(scanner);
    students[i] = student; // Store the student object in the array
}
        System.out.println("\nStudent Information:");
        for (Student student : students) {
            student.displayStudent();
            System.out.println();
        }

        scanner.close();
    }

        }

