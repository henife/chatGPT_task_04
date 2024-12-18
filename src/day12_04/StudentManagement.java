package day12_04;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private String ID;
    public static ArrayList<Course> courses = new ArrayList<>();

    public Student(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", courses=" + courses +
                '}';
    }

    static class Course {
        private String courseName;
        private double grade;

        public Course(String courseName, double grade) {
            this.courseName = courseName;
            this.grade = grade;
        }

        public String getCourseName() {
            return courseName;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "courseName='" + courseName + '\'' +
                    ", grade=" + grade +
                    '}';
        }

        public static void validation(double grade) {
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade");
            } else if (grade < 50) {
                System.out.println("Student failed this course.");
            }
        }
    }

    public static class StudentManagement {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayList<Student> students = new ArrayList<>();

            while (true) {
                System.out.println("""
                        1. Add a student.
                        2. Add a course.
                        3. Update a course grade for a student.
                        4. View all students.
                        5. Search for a student by name or ID.
                        6. Show the average grade.
                        7. Other request(trim white spaces, check null grades)
                        8. Exit the program.
                        """
                );
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> addInfo(students);
                    case 2 -> addCourse(students);
                    case 3 -> updateGrade(students);
                    case 4 -> viewAllStudent(students);
                    case 5 -> search(students);
                    case 6 -> average(students);
                    case 7 -> otherRequest(students);
                    case 8 -> {
                    System.out.println("Exiting the program.");
                    return;
                }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }

        public static void addInfo(ArrayList<Student> students) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the name of the student: ");
            String name = sc.nextLine();
            System.out.println("Please enter the ID of the student: ");
            String ID = sc.nextLine();

            Student student = new Student(name, ID);
            students.add(student);
            System.out.println("Student added successfully.");
        }
    }

    public static void addCourse(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the course: ");
        String courseName = sc.next();
        System.out.println("Please enter the grade of the course: ");
        double grade = sc.nextDouble();
        sc.nextLine();
        Course newCourse = new Course(courseName, grade);
        courses.add(newCourse);
        System.out.println("Please enter the student ID to add this course to: ");
        String studentID = sc.nextLine();
        for (Student student : students) {
            if (student.getID().equals(studentID)) {
                student.addCourse(newCourse);
                System.out.println("Course added successfully.");
                return;
            }
        }
    }

    public static void updateGrade(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the ID of the student: ");
        String studentID = sc.nextLine();
        System.out.println("please enter the course that you want to update: ");
        String courseName = sc.nextLine();
        System.out.println("Please enter the grade that you want to update: ");
        double newGrade = sc.nextDouble();
        sc.nextLine();

        for (Student student : students) {
            if (student.getID().equals(studentID)) {
                for (Student.Course course : student.getCourses()) {
                    if (course.getCourseName().equalsIgnoreCase(courseName)) {
                        course.setGrade(newGrade);
                        System.out.println("Grade updated successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Student or course not found.");
    }

    public static void viewAllStudent(ArrayList<Student> students) {
        for (Student eachStudent : students) {
            System.out.println(eachStudent);
        }
    }

    public static void search(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name or ID of the student: ");
        String identifier = sc.nextLine();
        students.forEach(student -> {
            if (identifier.equalsIgnoreCase(student.getName()) || identifier.equalsIgnoreCase(student.getID())) {
                System.out.println(student);
            }
        });
    }

    public static void average(ArrayList<Student> students) {
        for (Student student : students) {
            double sum = 0;
            int courseCount = student.getCourses().size();
            if (courseCount == 0) {
                System.out.println(student.getName() + " has no courses.");
                continue;
            }
            for (Student.Course course : student.getCourses()) {
                sum += course.getGrade();
            }
            double avg = sum / courseCount;
            System.out.println("The average grade of " + student.getName() + " is " + avg);
            if (avg < 50) {
                System.out.println("The average grade is lower than 50. is failed");
            }
        }
    }

    public static void otherRequest(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        String request = sc.nextLine();
        if (request.equalsIgnoreCase("check null grade")) {
            for (Student eachStudent : students) {
                for (Student.Course eachCourse : eachStudent.getCourses()) {
                    if (eachCourse.getGrade() == 0) {
                        System.out.println(eachStudent.getName());
                    }
                }
            }
        }
        if (request.equalsIgnoreCase("trim white spaces")) {
            for (Student eachStudent : students) {
                eachStudent.setName(eachStudent.getName().trim());
                eachStudent.setID(eachStudent.getID().trim());
            }
            System.out.println("Trimmed white spaces from student names and IDs.");
        }
    }
}