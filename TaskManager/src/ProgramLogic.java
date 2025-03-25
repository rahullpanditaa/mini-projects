import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramLogic {
    private List<Task> activeTasks;  // list that holds tasks currently active
    private final String FILE_NAME = "tasks.txt";

    public ProgramLogic() {
        this.activeTasks = new ArrayList<>();
        loadTasksFromFile();
    }

    public boolean isEmpty() {
        return activeTasks.isEmpty();
    }

    // adding tasks to list of active tasks
    public void addTask(Task task) {
        if (activeTasks.contains(task)) {   // checks whether task description is same
            return;
        }
        activeTasks.add(task);
        saveToFile();
    }

    // writing the tasks in active tasks list to a file
    public void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_NAME)){
            for (Task t : activeTasks) {
                writer.write(String.valueOf(t));
                writer.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    // loading the tasks in text file whenever program runs
    public void loadTasksFromFile() {
        try (Scanner reader = new Scanner(Paths.get(FILE_NAME))) {
            while (reader.hasNextLine()) {
                activeTasks.add(new Task(reader.nextLine()));
            }

        } catch (Exception e) {
            System.out.println("Unable to load previous task. Either no tasks exist or some other error.");
        }
        if (activeTasks.isEmpty()) {
            System.out.println("Unable to load previous tasks. Either no tasks exists or some other error.");
            System.out.println();
            return;
        }
        System.out.println("Here is your to-do list:");
        printTasks();
        System.out.println();
    }

    // remove a task
    // also add way to remove the task from file
    public void removeTask(int taskNumber) {
        int index = taskNumber-1;
        if (taskNumber < activeTasks.size() || taskNumber > activeTasks.size()) {
            System.out.println("No such task in your to-do list.");
            return;
        }
        activeTasks.remove(index);
        saveToFile();

    }

    // print all active tasks
    // add numbering to tasks
    public void printTasks() {
        if (activeTasks.isEmpty()) {
            System.out.println("No tasks");
            return;
        }
        for (int i = 0; i < activeTasks.size(); i++) {
            System.out.println((i+1) + ". " + activeTasks.get(i) );
        }
    }

    // mark a task in active tasks list as complete, given task number
    public void markAsCompleted(int taskNumber) {
        System.out.println("Tasks currently in to-do list:");
        printTasks();
        int index = taskNumber-1;
        if (taskNumber < activeTasks.size() || taskNumber > activeTasks.size()) {
            System.out.println("No such task in your to-do list.");
            return;
        }
        activeTasks.get(index).markTaskCompleted();
        saveToFile();
    }

    // set the priority of some task in active tasks list
    public void setPriority(int taskNumber, String priority) {
        System.out.println("Tasks currently in to-do list:");
        printTasks();
        int index = taskNumber-1;
        if (taskNumber < activeTasks.size() || taskNumber > activeTasks.size()) {
            System.out.println("No such task in your to-do list.");
            return;
        }
        activeTasks.get(index).setTaskPriority(priority);
        saveToFile();
    }

}
