import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Task {
    private String title;
    private String category;
    private LocalDateTime dueDate;
    private boolean isCompleted;

    public Task(String var1, String var2, LocalDateTime var3) {
        this.title = var1;
        this.category = var2;
        this.dueDate = var3;
        this.isCompleted = false;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public LocalDateTime getDueDate() {
        return this.dueDate;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public boolean isDueSoon() {
        return !this.isCompleted && this.dueDate.isBefore(LocalDateTime.now().plusHours(24L));
    }

    public String toString() {
        DateTimeFormatter var1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String var10000 = this.isCompleted ? "✓" : " ";
        return "[" + var10000 + "] " + this.title + " (" + this.category + ") - Due: " + this.dueDate.format(var1);
    }
}
