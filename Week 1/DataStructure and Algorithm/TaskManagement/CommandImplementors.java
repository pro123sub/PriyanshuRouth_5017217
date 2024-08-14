import java.util.Scanner;

public class CommandImplementors {
}
class AddTaskCommand implements Command {
    private TaskLinkedList taskList;
    private Scanner scanner;

    public AddTaskCommand(TaskLinkedList taskList, Scanner scanner) {
        this.taskList = taskList;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter Task ID:");
        String taskId = scanner.nextLine();
        System.out.println("Enter Task Name:");
        String taskName = scanner.nextLine();
        System.out.println("Enter Task Status:");
        String status = scanner.nextLine();

        Task task = new Task(taskId, taskName, status);
        taskList.addTask(task);
        System.out.println("Task added successfully.");
    }
}

class SearchTaskCommand implements Command {
    private TaskLinkedList taskList;
    private Scanner scanner;

    public SearchTaskCommand(TaskLinkedList taskList, Scanner scanner) {
        this.taskList = taskList;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter Task ID to search:");
        String taskId = scanner.nextLine();
        Task task = taskList.searchTask(taskId);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Task not found.");
        }
    }
}

class TraverseTasksCommand implements Command {
    private TaskLinkedList taskList;

    public TraverseTasksCommand(TaskLinkedList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute() {
        taskList.traverseTasks();
    }
}

class DeleteTaskCommand implements Command {
    private TaskLinkedList taskList;
    private Scanner scanner;

    public DeleteTaskCommand(TaskLinkedList taskList, Scanner scanner) {
        this.taskList = taskList;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Enter Task ID to delete:");
        String taskId = scanner.nextLine();
        if (taskList.deleteTask(taskId)) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }
}