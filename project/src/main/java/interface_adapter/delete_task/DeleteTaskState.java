package interface_adapter.delete_task;

import entity.Project;
import interface_adapter.add_task.AddTaskState;

public class DeleteTaskState {
    private String taskName = "";
    private Project project;

    public DeleteTaskState(DeleteTaskState copy) {
        taskName = copy.taskName;
        project = copy.project;
    }

    public DeleteTaskState() {}

    public String getTaskName() {
        return taskName;
    }

    public Project getProject() {
        return project;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
