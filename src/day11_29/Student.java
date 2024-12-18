package day11_29;

public class Student {
    private String name;
    private int[] grade;

    public Student(String name, int[] grade) {
        this.name = name;
        this.grade = grade;
    }

    public static void main(String[] args) {

        Student[] students = new Student[3];
        students[0] = new Student("John", new int[]{89, 78, 91});
        students[1] = new Student("Jane", new int[]{89, 88, 99});
        students[2] = new Student("Mary", new int[]{89, 78, 69});

        for (Student student : students) {
            System.out.println(student);
            student.getLetterGrade();
        }
    }

    public String getName() {
        return name;
    }

    public int[] getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "day11_29.Student{" +
                "name='" + name.toUpperCase() + '\n' +
                "Average grade=" + String.format("%.2f" , calculateAverage()) + "\n" +
                '}';
    }

    public double calculateAverage() {
        int sum = 0;
        for(int grade : grade) {
            sum += grade;
        }
        return (double) sum / grade.length;

    }

    public void getLetterGrade() {
        double average = calculateAverage();
        char gradeClassification = 'F';
        if (average > 100 || average < 0) {
            System.out.println("Invalid grade");
        } else if (average >= 90) {
            gradeClassification = 'A';
        } else if (average >= 80) {
            gradeClassification = 'B';
        } else if (average >= 70) {
            gradeClassification = 'C';
        } else if (average >= 60) {
            gradeClassification = 'D';
        }
        System.out.println(name + "'s grade classification is: " + gradeClassification);
    }
}
