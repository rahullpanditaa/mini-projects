// a task is a separate concept
// needs its own class to allow for adding task completion and prioritization
public class Task {
    private final String description;  // what is the task
    private boolean isCompleted;  // default is false
    private String priority;      // High, Medium, Low - default is Low

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
        this.priority = "Low";
    }

    // getters and setters
    public String getTaskDescription() { return this.description; }

    public boolean isTaskCompleted() { return this.isCompleted; }
    public void markTaskCompleted() { this.isCompleted = true; }

    public String getTaskPriority() { return this.priority; }
    public void setTaskPriority(String priority) {
        priority = priority.trim();
        if (getTaskPriority().equals(priority)) {
            System.out.println("The task " + getTaskDescription() + " already has " + priority + " priority.");
            return;
        }
        if (priority.equals("High") || priority.equals("Medium") || priority.equals("Low")) {
            this.priority = priority;
            return;
        }
        System.out.println("Invalid priority type given: Please select a valid option.");
    }

    public String toString() {
        return getTaskDescription() + (isTaskCompleted() ? " - Finished :)" : " - Incomplete :(") + " (Priority: " + getTaskPriority() + ").";
    }

    public boolean equals(Object another) {
        if (this == another) { return true; }
        if (getClass() != another.getClass()) { return false; }

        Task task = (Task) another;

        return this.getTaskDescription().equals(task.getTaskDescription());
    }


}
