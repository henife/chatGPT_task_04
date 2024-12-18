package day12_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

class Employee {
    public String name;
    public String department;
    public double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("""
                    1. Add an employee.
                    2. Update an employee's salary.
                    3. View all employees.
                    4. Search for an employee by name.
                    5. Calculate the total payroll.
                    6. Exit the program.
                    """
            );
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addEmployee(employees);
                case 2 -> updateSalary(employees);
                case 3 -> viewAllEmployees(employees);
                case 4 -> searchName(employees);
                case 5 -> calculatePayroll(employees);
                case 6 -> {
                    System.out.println("exiting the program.");
                    exit(0);
                }
                default -> System.out.println("invalid choice");
            }
        }
    }

    public static void addEmployee(ArrayList<Employee> employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the employee you would like to add: ");
        String name = scanner.nextLine();
        System.out.println("Please enter the department of the employee: ");
        String department = scanner.nextLine();
        System.out.println("Please enter the salary of the employee: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Employee newEmployee = new Employee(name, department, salary);
        employees.add(newEmployee);
        System.out.println("Employee added successfully!");
    }

    public static void updateSalary(ArrayList<Employee> employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the employee you would like to update: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(name)) {
                System.out.println(name + " 's current salary is " + employee.getSalary());
                System.out.println("Please enter the new salary of the employee: ");
                double Newsalary = scanner.nextDouble();
                employee.setSalary(Newsalary);
                System.out.println("Employee updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found");
        }
    }

    public static void viewAllEmployees(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("There are no employees.");
        } else {
            System.out.println("\nList of employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public static void searchName(ArrayList<Employee> employees) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the employee that you would like to search: ");
        String searched = scanner.nextLine();
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(searched)) {
                System.out.println(employee);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found");
        }
    }

    public static void calculatePayroll(ArrayList<Employee> employees) {
        double total = 0;
        for (Employee employee : employees) {
            total += employee.getSalary();
        }
        System.out.println("Total payroll is : " + total);
    }
}