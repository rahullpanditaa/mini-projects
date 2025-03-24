// a task is a separate concept
// needs its own class to allow for adding task completion and prioritization
public class Task {
    private String description;
    private boolean isCompleted;
    private String priority;  // (High, medium or low)

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
        this.priority = "Low";  // default
    }

    public boolean isTaskCompleted() { return this.isCompleted; }
    public void markTaskComplete() { this.isCompleted = true;}

    public String getTaskPriority() { return this.priority; }
    public void setTaskPriority(String p) { this.priority = p;}

    public String getDescription() { return this.description; }

    public String toString() {
        return this.getDescription() + "; Status: " + (isTaskCompleted() ? "[✔️]" : "[ ]") + " (Priority: " + getTaskPriority() + ")";
    }

    public boolean equals(Object another) {
        if (this == another ) { return true; }
        if (another == null || this.getClass() != another.getClass()) { return false; }

        Task task = (Task) another;
        return this.description.equals(((Task) another).description);  // this seems pointless right now
    }
}
