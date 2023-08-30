
import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private LocalDateTime reminderDate;

    public Task(String title, String description, LocalDateTime dueDate, LocalDateTime reminderDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.reminderDate = reminderDate;
    }

    // Getters and setters for attributes (title, description, dueDate, reminderDate)

    @Override
    public String toString() {
        String taskString = "Title: " + title + "\n"
                + "Description: " + description + "\n"
                + "Due Date: " + dueDate + "\n";

        if (reminderDate != null) {
            taskString += "Reminder Date: " + reminderDate + "\n";
        }

        return taskString;
    }

	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalDateTime getReminderDate() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

