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
            System.out.println("Following features are available in TaskManager V 1.0:");
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
}
