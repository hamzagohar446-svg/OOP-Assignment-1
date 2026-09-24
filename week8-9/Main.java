import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        loadTasks(tasks);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("Study task notebook");
            System.out.println("1. Show tasks");
            System.out.println("2. Add a task");
            System.out.println("3. Mark a task as done");
            System.out.println("4. Save to " + FILE_NAME);
            System.out.println("5. Reload from " + FILE_NAME);
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                showTasks(tasks);
            } else if (choice.equals("2")) {
                System.out.print("Task description: ");
                String description = scanner.nextLine().trim();
                if (description.isEmpty()) {
                    System.out.println("Nothing was added.");
                } else {
                    tasks.add(new Task(description, false));
                    System.out.println("Task added.");
                }
            } else if (choice.equals("3")) {
                showTasks(tasks);
                System.out.print("Task number to complete: ");
                String raw = scanner.nextLine().trim();
                try {
                    int number = Integer.parseInt(raw);
                    if (number < 1 || number > tasks.size()) {
                        System.out.println("That number is not in the list.");
                    } else {
                        tasks.get(number - 1).markDone();
                        System.out.println("Marked as done.");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Enter a number.");
                }
            } else if (choice.equals("4")) {
                saveTasks(tasks);
            } else if (choice.equals("5")) {
                tasks.clear();
                loadTasks(tasks);
            } else if (choice.equals("6")) {
                running = false;
            } else {
                System.out.println("Choose 1 to 6.");
            }
        }

        scanner.close();
        System.out.println("Notebook closed.");
    }

    private static void showTasks(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void saveTasks(ArrayList<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.toFileLine());
                writer.newLine();
            }
            System.out.println("Saved " + tasks.size() + " task(s) to " + FILE_NAME + ".");
        } catch (IOException ex) {
            System.out.println("Could not save the file: " + ex.getMessage());
        }
    }

    private static void loadTasks(ArrayList<Task> tasks) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    tasks.add(Task.fromFileLine(line.trim()));
                    count++;
                }
            }
            System.out.println("Loaded " + count + " task(s) from " + FILE_NAME + ".");
        } catch (IOException ex) {
            System.out.println("No saved file yet. Starting with an empty list.");
        }
    }
}
