import java.util.ArrayList;
import java.util.List;

public class ProgramLogic {
    private List<String> activeTasks;  // list that holds tasks currently active

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
    }

    // remove a task
    public void removeTask(String task) {
        if (activeTasks.contains(task)) {
            activeTasks.remove(task);
        }
        System.out.println("No such task in your to-do list.");
    }

    // print all active tasks
    // add numbering to tasks
    public void printTasks() {
        for (int i = 0; i < activeTasks.size(); i++) {
            System.out.println((i+1) + ". " + activeTasks.get(i) );
        }
    }
}
