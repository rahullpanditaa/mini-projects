import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private ProgramLogic taskManager;

    public UserInterface(Scanner scanner, ProgramLogic taskManager) {
        this.scanner = scanner;
        this.taskManager = taskManager;
    }

    // start user interface
    public void start() {
        while (true) {
            System.out.println("Following features are available in TaskManager V 2.0:");
            System.out.println("[1] - add a task.");
            System.out.println("[2] - remove a task (only if completed, you lazy bastard).");
            System.out.println("[3] - show active tasks.");
            System.out.println("[X] - exit.");
            String command = scanner.nextLine();
            if (command.equals("X")) {
                break;
            }
            processCommand(command);
        }
    }

    public void processCommand(String command) {
        if (command.equals("1")) {
            add();   // method that takes care of updating task list
        } else if (command.equals("2")) {
            remove();
        }else if (command.equals("3")) {
            print();
        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }

    // add a command to task manager
    public void add() {
        System.out.println("What do you want to do?");
        String input = scanner.nextLine();
        taskManager.addTask(input);
        System.out.println();
    }

    // remove a task
    public void remove() {
        System.out.println("Which task do you want to delete?");
        int input = Integer.valueOf(scanner.nextLine());
        taskManager.removeTask(input);
        System.out.println();
    }

    // show all tasks
    public void print() {
        taskManager.printTasks();
        System.out.println();
    }
}
