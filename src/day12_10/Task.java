package day12_10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Task {
    private String title;
    private String description;
    private String dueDate;
    private boolean isComplete;
    private String priority;

    public Task(String title, String description, String dueDate, boolean isComplete, String priority) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = isComplete;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", isComplete=" + isComplete +
                ", priority='" + priority + '\'' +
                '}';
    }
}

class TaskCompletion {
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1. Add Task.
                    2. View All Tasks.
                    3. Mark Task as Completed.
                    4. Delete Task.
                    5. View Completed Tasks.
                    6. View Incomplete Tasks.
                    7. Sort.
                    8. Exit Program.
                    """);

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> addTask(tasks);
                case 2 -> viewAllTasks(tasks);
                case 3 -> markTaskAsCompleted(tasks);
                case 4 -> deleteTask(tasks);
                case 5 -> viewCompletedTasks(tasks);
                case 6 -> viewIncompleteTasks(tasks);
                case 7 -> sortTasks(tasks);
                case 8 -> {
                    System.out.println("System exiting");
                    return;
                }
                default -> System.out.println("Invalid choice");

            }
        }
    }

    public static void addTask(ArrayList<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of the task you would like to add: ");
        String title = scanner.nextLine();
        System.out.println("Please enter the description of the task you would like to add: ");
        String description = scanner.nextLine();
        System.out.println("Please enter the due date of the task you would like to add: ");
        String dueDate = scanner.nextLine();
        System.out.println("Please enter the priority of the task you would like to add: ");
        String priority = scanner.nextLine();

        tasks.add(new Task(title, description, dueDate, false, priority));
        System.out.println("New task added successfully.");
    }

    public static void viewAllTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks in the system.");
        } else {
            for (Task task : tasks) {
                System.out.println("These are the tasks of the system: ");
                System.out.println(task);
            }
        }
    }

    public static void markTaskAsCompleted(ArrayList<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of the task that already have been completed: ");
        String CompletedTitle = scanner.nextLine();
        boolean found = false;
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(CompletedTitle)) {
                task.setComplete(true);
                System.out.println(task.getTitle() + " is completed.");
                found = true;
                break;
            } else {
                System.out.println("No task found with that title.");
            }
        }
    }

    public static void deleteTask(ArrayList<Task> tasks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the title of the task that you would like to delete: ");
        String deleteTitle = scanner.nextLine();
        boolean removed = tasks.removeIf(task -> task.getTitle().equalsIgnoreCase(deleteTitle));
        if (removed) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("No task found with that title.");
        }
    }

    public static void viewCompletedTasks(ArrayList<Task> tasks) {
        boolean found = false;
        for (Task task : tasks) {
            if (task.isComplete()) {
                if (!found) {
                    System.out.println("Here is the list of tasks that already completed:");
                    found = true;
                }
                System.out.println(task);
            }
        }
        if (!found) {
            System.out.println("No task found with that title.");
        }
    }

    public static void viewIncompleteTasks(ArrayList<Task> tasks) {
        boolean found = false;
        for (Task task : tasks) {
            if (!task.isComplete()) {
                if (!found) {
                    System.out.println("Here are the incomplete tasks:");
                    found = true;
                }
                System.out.println(task);
            }
        }
        if (!found) {
            System.out.println("No tasks are incomplete.");
        }
    }

    public static void sortTasks(ArrayList<Task> tasks) {
        System.out.println("In this section you can see the task ordered by it's complex status(from easy to hard) :");
        tasks.sort(Comparator.comparing(Task::getPriority));
        viewAllTasks(tasks);
    }
}
