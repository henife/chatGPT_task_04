package day12_10;

import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private String fullName;
    private String ID;
    private String position;
    private double salary;

    public Employee(String name, String ID, String position, double salary) {
        this.fullName = name;
        this.ID = ID;
        this.position = position;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public String getID() {
        return ID;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + fullName + '\'' +
                ", ID='" + ID + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class EmployeeManagement{

    static ArrayList<Employee> employees = new ArrayList<Employee>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please enter the password to proceed: ");
        String password = scanner.nextLine();

        if(password.isEmpty() || !password.equals("admin123")) {
            System.out.println(" wrong password!!! ");
            return;
        }
        while (true){
            System.out.println("""
                    1. Add Employee:
                    2. Delete Employee:
                    3. Update Employee:
                    4. View All Employees:
                    5. Exit Program
                    """);

            int choice = scanner.nextInt();
            switch(choice) {
                case 1 ->
                    addEmployee(employees);
                case 2 ->
                    deleteEmployee(employees);
                case 3 ->
                    updateEmployee(employees);
                case 4 ->
                    viewAllEmployees(employees);
                case 5 -> {
                    System.out.println("Exiting the Program");
                    return;
                }
            }
        }
    }
    public static void addEmployee(ArrayList<Employee> employees){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" please enter the name of the employee:");
        String name = scanner.nextLine();
        System.out.println(" please enter the ID of the employee:");
        String ID = scanner.nextLine();
        System.out.println(" please enter the position of the employee:");
        String position = scanner.nextLine();
        System.out.println(" please enter the salary of the employee:");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        Employee employee = new Employee(name, ID, position, salary);
        employees.add(employee);
        System.out.println(" Employee added successfully!");
        }
        public static void deleteEmployee(ArrayList<Employee> employees) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" please enter the ID of the employee:");
            String ID = scanner.nextLine();
            boolean removed = employees.removeIf(p -> p.getID().equals(ID));
            if (removed) {
                System.out.println("employee deleted successfully");
            }
            System.out.println("employee not found");
        }
        public static void updateEmployee(ArrayList<Employee> employees) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" please enter the ID of the employee:");
            String ID = scanner.nextLine();
            for (Employee eachEmployee : employees) {
                if (eachEmployee.getID().equals(ID)) {
                    System.out.println("What kind of change would you like to make? name/position/salary");
                    String kind = scanner.nextLine();
                    if (kind.equals("name")) {
                        System.out.println("Please enter the new name of the employee:");
                        String newName = scanner.nextLine();
                        eachEmployee.setFullName(newName);
                        System.out.println(eachEmployee.getFullName() + " 's name has been updated");
                    }
                    if (kind.equals("position")) {
                        System.out.println("Please enter the new position of the employee:");
                        String newPosition = scanner.nextLine();
                        eachEmployee.setPosition(newPosition);
                        System.out.println(eachEmployee.getFullName() + " 's position has been updated");
                    }
                    if (kind.equals("salary")) {
                        System.out.println("Please enter the new salary of the employee:");
                        double newSalary = scanner.nextDouble();
                        eachEmployee.setSalary(newSalary);
                        System.out.println(eachEmployee.getFullName() + " 's salary has been updated");
                    }
                }

            }
        }
        public static void viewAllEmployees(ArrayList<Employee> employees){
        employees.forEach(System.out::println);
        }
    }
