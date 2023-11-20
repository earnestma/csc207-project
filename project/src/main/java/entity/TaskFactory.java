package project.src.main.java.entity;

public class TaskFactory {
    public Task create(String taskName, String dueDate) {
        return new Task(taskName, dueDate);
    }
}
