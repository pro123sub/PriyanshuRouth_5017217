import java.util.LinkedList;
import java.util.Iterator;

public class TaskLinkedList {
    private LinkedList<Task> tasks;

    public TaskLinkedList() {
        tasks = new LinkedList<>();
    }

    // Add a task to the end of the list
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Search for a task by ID
    public Task searchTask(String taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
            return;
        }
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // Delete a task by ID
    public boolean deleteTask(String taskId) {
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getTaskId().equals(taskId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
