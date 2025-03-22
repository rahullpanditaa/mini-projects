import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramLogic {
    private List<String> activeTasks;  // list that holds tasks currently active
    private final String FILE_NAME = "tasks.txt";

    public ProgramLogic() {
        this.activeTasks = new ArrayList<>();
    }

    public boolean isEmpty() {
        return activeTasks.isEmpty();
    }

    // adding tasks to list of active tasks
    public void addTask(String task) {
        if (activeTasks.contains(task)) {
            return;
        }
        activeTasks.add(task);
        saveToFile();
    }

    // writing the tasks in active tasks list to a file
    public void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)){
            for (String t : activeTasks) {
                writer.write(t);
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // loading the tasks in text file whenever program runs

    // remove a task
    public void removeTask(int taskNumber) {
        if (taskNumber - 1 <= activeTasks.size() || taskNumber - 1 >= activeTasks.size()) {
            System.out.println("No such task in your to-do list.");
        }
        activeTasks.remove(taskNumber-1);

    }

    // print all active tasks
    // add numbering to tasks
    public void printTasks() {
        for (int i = 0; i < activeTasks.size(); i++) {
            System.out.println((i+1) + ". " + activeTasks.get(i) );
        }
    }
}
