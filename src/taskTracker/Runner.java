package taskTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private static Object sc;
    // List to hold tasks
    private ArrayList<Task> tasks = new ArrayList<>();
    private int taskCounter = 1;
    // Method to add a task to the list
    public void addTask(String description) {
        Task task = new Task(taskCounter++, description, Status.TO_DO, LocalDateTime.now());
        tasks.add(task);
    }
    //Method to list tasks in the ArrayList
    public void listTasks() {
        for (Task task : tasks) {
            System.out.println("ID: " + task.getId());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Status: " + task.getStatus());
            System.out.println("Created At: " + task.getCreatedAt());
            System.out.println("Updated At: " + task.getUpdatedAt());
            System.out.println("-------------------");
        }
    }
    // Method to write the tasks to a file in JSON format
    public void writeToFile() {
        StringBuilder json = new StringBuilder("[");
        for (Task task : tasks) {
            json.append("{")
                    .append("\"id\":").append(task.getId()).append(",")
                    .append("\"description\":\"").append(task.getDescription()).append("\",")
                    .append("\"status\":\"").append(task.getStatus()).append("\",")
                    .append("\"createdAt\":\"").append(task.getCreatedAt()).append("\",")
                    .append("\"updatedAt\":\"").append(task.getUpdatedAt()).append("\"")
                    .append("},");
        }
        if (json.length() > 1) json.deleteCharAt(json.length() - 1); // Remove trailing comma
        json.append("]");

        try (FileWriter writer = new FileWriter("tasks.json")) {
            writer.write(json.toString());
            System.out.println("Tasks saved to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    // Main method to interact with the user and run the program
    public static void main(String[] args) {
        Runner taskManager = new Runner(); // Create an instance of Runner

        System.out.println("Welcome to the taskTracker.");
        

        while (true) {
            System.out.println("\nChoose an option: \n1. Create New Task\n2. Update Task\n3. Delete Task\n4. Exit");

            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter task description: ");
                    String description = sc.nextLine();

                    taskManager.addTask(description);
                    taskManager.writeToFile();
                    break;

                case 2:
                    taskManager.listTasks();
                    System.out.println("Enter the ID of the task you want to update:");
                    int updateId = sc.nextInt();

                    Task taskToUpdate = null;
                    for (Task task : taskManager.tasks) {
                        if (task.getId() == updateId) {
                            taskToUpdate = task;
                            break;
                        }
                    }

                    if (taskToUpdate == null) {
                        System.out.println("Task with ID " + updateId + " not found.");
                        break;
                    }

                    System.out.println("What would you like to update?");
                    System.out.println("1. Description\n2. Status\n3. Both");
                    int updateOption = sc.nextInt();
                    sc.nextLine();

                    if (updateOption == 1 || updateOption == 3) {
                        System.out.print("Enter new description: ");
                        String newDescription = sc.nextLine();
                        taskToUpdate.setDescription(newDescription);
                    }

                    if (updateOption == 2 || updateOption == 3) {
                        System.out.println("Select new status: 1. TO_DO, 2. IN_PROGRESS, 3. DONE");
                        int statusChoice = sc.nextInt();
                        switch (statusChoice) {
                            case 1:
                                taskToUpdate.setStatus(Status.TO_DO);
                                break;
                            case 2:
                                taskToUpdate.setStatus(Status.IN_PROGRESS);
                                break;
                            case 3:
                                taskToUpdate.setStatus(Status.DONE);
                                break;
                            default:
                                System.out.println("Invalid status choice.");
                                break;
                        }
                    }
                    break;

                case 3:
                    taskManager.listTasks();
                    System.out.print("Enter the ID of the task you want to delete: ");
                    int deleteId = sc.nextInt();

                    Task taskToDelete = null;
                    for (Task task : taskManager.tasks) {
                        if (task.getId() == deleteId) {
                            taskToDelete = task;
                            break;
                        }
                    }

                    if (taskToDelete != null) {
                        taskManager.tasks.remove(taskToDelete);
                        System.out.println("Task with ID " + deleteId + " deleted successfully.");
                        taskManager.writeToFile();
                    } else {
                        System.out.println("Task with ID " + deleteId + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please choose a valid option.");
                    break;
            }
        }
    }
}
