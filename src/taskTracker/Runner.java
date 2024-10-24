package taskTracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    ArrayList <Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public static void main(String[] args) {
        Runner taskManager = new Runner();

        System.out.println("Welcome to the taskTracker.");
        System.out.println("\n Choose an option. \n1. Create New Task\n2. Update Task\n3. Delete Task\n4. Exit");

        Scanner sc = new Scanner(System.in);
        switch(sc.nextInt()) {
            case 1:
                System.out.print("Enter task ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter task description: ");
                String description = sc.nextLine();
                taskManager.addTask(new Task(id, description, Status.TO_DO, LocalDateTime.now()));
                break;
            case 2:
                System.out.print("Enter task ID: ");
                break;
            case 3:
                System.out.print("Enter task description: ");
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Enter valid option.");
                break;
        }
    }
}
