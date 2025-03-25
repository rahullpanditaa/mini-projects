import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ProgramLogic pl = new ProgramLogic();
//
//        UserInterface ui = new UserInterface(scanner, pl);
//
//        ui.start();
        Task task = new Task("Do Laundry");
        System.out.println(task.getTaskDescription());
        System.out.println(task.getTaskPriority());
        task.setTaskPriority("High");
        System.out.println(task.getTaskPriority());
        System.out.println(task.isTaskCompleted());
//        task.markTaskCompleted();
        System.out.println(task.isTaskCompleted());
        System.out.println(task);


    }
}
