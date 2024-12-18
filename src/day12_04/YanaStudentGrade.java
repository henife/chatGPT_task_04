package day12_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class YanaStudentGrade {

    static class Student {

        private String name;
        private int grade;

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("how many students do you want to enter?");
        int length = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < length; i++) {
            System.out.println("please enter the name of the student " + (i + 1));
            String name = scanner.nextLine();

            int grade;
            while (true) {
                System.out.println("please enter the grade of the " + name);
                grade = scanner.nextInt();
                scanner.nextLine();

                if (grade >= 0 && grade <= 100) {
                    break;
                } else {
                    System.out.println("Invalid grade! Please enter a grade between 0 and 100.");
                }
            }
            students.add(new Student(name, grade));
        }

       double average = calculateAverage(students);
               System.out.println("Average grade: " + average);

               // Display the top scorer
               String topScorer = getTopScorer(students);
               System.out.println("Top scorer: " + topScorer);

               // List of failing students
               System.out.println("Failing students:");
               printFailingStudents(students);

               // Sort and display students by grade
               System.out.println("Students sorted by grade:");
               sortAndDisplayStudents(students);

               scanner.close();
    }


    public static double calculateAverage(ArrayList<Student> students) {
        int sum = 0;
        int average = 0;

        for (Student student : students) {
            sum += student.grade;
        }
        return sum / (double) students.size();
    }
      public static String getTopScorer(ArrayList<Student> students) {
              Student topStudent = students.get(0);
              for (Student student : students) {
                  if (student.grade > topStudent.grade) {
                      topStudent = student;
                  }
              }
              return topStudent.name;
          }
    public static void printFailingStudents(ArrayList<Student> students) {
        for (Student student : students) {
            if (student.grade < 50) {
                System.out.println(student.name + " - Grade: " + student.grade);
            }
        }
    }

    // Sort students by their grade in descending order and display them
    public static void sortAndDisplayStudents(ArrayList<Student> students) {
        students.sort((s1, s2) -> Integer.compare(s2.grade, s1.grade)); // Sorting in descending order
        for (Student student : students) {
            System.out.println(student.name + " - Grade: " + student.grade);
        }
    }
            }

