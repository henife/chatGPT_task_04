package day12_10;

import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeComplex {
    private String name;
    private String ID;
    private String department;
    private double salary;

    public EmployeeComplex(String name, String ID, String department, double salary) {
        this.name = name;
        this.ID = ID;
        this.department = department;
        this.salary = salary;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeComplex{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class Manager extends EmployeeComplex{
    private double bonus;
    public Manager(String name, String ID, String department, double salary, double bonus) {
        super(name, ID, department, salary);
        this.bonus = bonus;
    }
    public double getBonus() {
        return bonus;
    }
}
class EmployeeManagementSystem {
    static ArrayList<EmployeeComplex> employeesComplex = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    1. Add Employee
                    2. View Employees
                    3. Update Employee
                    4. Delete Employee
                    5. Exit.
                    
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 ->
                    addEmployee(employeesComplex);
                case 2 ->
                    viewEmployees(employeesComplex);
                case 3 ->
                    updateEmployee(employeesComplex);
                case 4 ->
                    deleteEmployee(employeesComplex);
                case 5 -> {
                    System.out.println("System is exiting");
                    break;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void addEmployee(ArrayList<EmployeeComplex> employeesComplex) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Plese enter the name of the employee you would like to add");
        String name = scanner.nextLine();
        System.out.println("Plese enter the ID of the employee");
        String ID = scanner.nextLine();
        System.out.println("Plese enter the department of the employee");
        String department = scanner.nextLine();
        System.out.println("Plese enter the salary of the employee");
        double salary = scanner.nextDouble();

        EmployeeComplex newEmployee = new EmployeeComplex(name, ID, department, salary);
        employeesComplex.add(newEmployee);
    }

    public static void viewEmployees(ArrayList<EmployeeComplex> employeesComplex) {
        if (employeesComplex.isEmpty()) {
            System.out.println("Employee system is empty");
        }  else {
            for (EmployeeComplex employee : employeesComplex) {
                System.out.println(employee);
            }
        }
    }

    public static void updateEmployee(ArrayList<EmployeeComplex> employeesComplex) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ID of the employee");
        String ID = scanner.nextLine();
        for (EmployeeComplex employee : employeesComplex) {
            if (ID.equals(employee.getID())) {
                System.out.println("what would you like to update? name / department / Salary");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "name" -> {
                        System.out.println("please enter the new name of the employee");
                        String newName = scanner.nextLine();
                        employee.setName(newName);
                        System.out.println("New name updated");
                    }
                    case "department" -> {
                        System.out.println("please enter the new department of the employee");
                        String newDepartment = scanner.nextLine();
                        employee.setDepartment(newDepartment);
                        System.out.println("New department updated");
                    }
                    case "salary" -> {
                        System.out.println("please enter the new salary of the employee");
                        double newSalary = scanner.nextDouble();
                        employee.setSalary(newSalary);
                        System.out.println("New salary updated");
                    }
                }
            }
        }
    }
    public static void deleteEmployee(ArrayList<EmployeeComplex> employeesComplex) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the ID of the employee");
        String ID = scanner.nextLine();
        for (EmployeeComplex employee : employeesComplex) {
            if (ID.equals(employee.getID())) {
                employeesComplex.remove(employee);
                System.out.println("Employee deleted");
            }
        }
    }
}