import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(String title, String category, LocalDateTime dueDate) {
        tasks.add(new Task(title, category, dueDate));
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        int index = 1;
        for (Task task : tasks) {
            System.out.println(index++ + ". " + task);
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void showUpcomingTasks() {
        System.out.println("Upcoming tasks:");
        LocalDateTime now = LocalDateTime.now();
        boolean found = false;

        for (Task task : tasks) {
            if (!task.isCompleted() && task.getDueDate().isAfter(now)) {
                System.out.println("- " + task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No upcoming tasks.");
        }
    }
}
