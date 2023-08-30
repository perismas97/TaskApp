
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TaskManager {
    private ArrayList<Task> tasks;
    private ScheduledExecutorService executor;

    public TaskManager() {
        tasks = new ArrayList<>();
        executor = Executors.newScheduledThreadPool(1);
    }

    public void addTask(Task task) {
        tasks.add(task);

        // Schedule reminder if reminder date is set
        if (task.getReminderDate() != null) {
            long delay = calculateDelay(task.getReminderDate());
            executor.schedule(() -> remindTask(task), delay, TimeUnit.SECONDS);
        }
    }

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task " + (i + 1) + ":\n" + tasks.get(i));
        }
    }

    private void remindTask(Task task) {
        System.out.println("Reminder: Task \"" + task.getTitle() + "\" is due soon!");
    }

    private long calculateDelay(LocalDateTime reminderDate) {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, reminderDate);
        return Math.max(0, duration.getSeconds());

    }

    public void showTaskManagerWindow() {
        // This method can be expanded for GUI integration
        // For example, displaying the tasks in a JavaFX window
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task | 2. List Tasks | 3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter task title:");
                    String title = scanner.nextLine();

                    System.out.println("Enter task description:");
                    String description = scanner.nextLine();

                    System.out.println("Enter due date (yyyy-MM-dd HH:mm):");
                    LocalDateTime dueDate = LocalDateTime.parse(scanner.nextLine());

                    System.out.println("Enter reminder date (yyyy-MM-dd HH:mm) or leave empty:");
                    String reminderInput = scanner.nextLine();
                    LocalDateTime reminderDate = reminderInput.isEmpty() ? null : LocalDateTime.parse(reminderInput);

                    Task newTask = new Task(title, description, dueDate, reminderDate);
                    taskManager.addTask(newTask);
                    System.out.println("Task added!");

                    break;

                case 2:
                    taskManager.listTasks();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


