import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n==================== TO-DO MENU ====================");
            System.out.println("1. Add new task");
            System.out.println("2. Show all tasks");
            System.out.println("3. Mark task as completed");
            System.out.println("4. Show upcoming tasks");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter task name: ");
                    String title = scanner.nextLine();

                    System.out.println("\nSelect Category:");
                    System.out.println("1. Personal");
                    System.out.println("2. Work");
                    System.out.println("3. School");
                    System.out.print("Choose option (1/2/3): ");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine();

                    String category = "";
                    switch (categoryChoice) {
                        case 1:
                            category = "Personal";
                            break;
                        case 2:
                            category = "Work";
                            break;
                        case 3:
                            category = "School";
                            break;
                        default:
                            System.out.println(" Invalid category, defaulting to 'Personal'.");
                            category = "Personal";
                    }

                    LocalDateTime dueDate = null;
                    boolean validDate = false;
                    while (!validDate) {
                        System.out.print("\nEnter due date (yyyy-MM-dd HH:mm): ");
                        String dueStr = scanner.nextLine();
                        try {
                            dueDate = LocalDateTime.parse(dueStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                            if (dueDate.isAfter(LocalDateTime.now())) {
                                validDate = true;
                            } else {
                                System.out.println(
                                        " Error: The due date cannot be in the past. Please enter a valid future date.");
                            }
                        } catch (Exception e) {
                            System.out.println(
                                    " Invalid date format. Please enter the date in 'yyyy-MM-dd HH:mm' format.");
                        }
                    }

                    manager.addTask(title, category, dueDate);
                    System.out.println("\n Task added successfully!\n");
                    break;

                case 2:
                    System.out.println("\n========= Your Tasks =========");
                    manager.listTasks();
                    break;

                case 3:
                    System.out.println("\n========= Mark Task as Completed =========");
                    manager.listTasks();
                    System.out.print("\nEnter task number to mark as completed: ");
                    int index = scanner.nextInt() - 1;
                    manager.markTaskAsCompleted(index);
                    break;

                case 4:
                    System.out.println("\n========= Upcoming Tasks =========");
                    manager.showUpcomingTasks();
                    break;

                case 5:
                    System.out.println("\n Exiting the program...\n");
                    scanner.close();
                    return;

                default:
                    System.out.println("\n Invalid option, please try again.");
            }
        }
    }
}
