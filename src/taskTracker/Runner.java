package taskTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    // List to hold tasks
    private ArrayList<Task> tasks = new ArrayList<>();

    // Method to add a task to the list
    public void addTask(Task task) {
        tasks.add(task);
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

    // Main method to interact with the user
    public static void main(String[] args) {
        Runner taskManager = new Runner(); // Create an instance of Runner

        System.out.println("Welcome to the taskTracker.");
        System.out.println("\nChoose an option: \n1. Create New Task\n2. Update Task\n3. Delete Task\n4. Exit");

        Scanner sc = new Scanner(System.in);

        while (true) {
            switch (sc.nextInt()) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // Consume the newline left-over
                    System.out.print("Enter task description: ");
                    String description = sc.nextLine();

                    // Create a new task and add it
                    taskManager.addTask(new Task(id, description, Status.TO_DO, LocalDateTime.now()));

                    // Write tasks to the file
                    taskManager.writeToFile();
                    break;

                case 2:
                    System.out.println("Feature to update a task will be implemented.");
                    break;

                case 3:
                    System.out.println("Feature to delete a task will be implemented.");
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
