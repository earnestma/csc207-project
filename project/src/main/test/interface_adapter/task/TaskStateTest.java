package interface_adapter.task;

import entity.Project;
import entity.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TaskStateTest {
    TaskState state;

    @BeforeEach
    void init() {
        state = new TaskState();
    }

    @Test
    void constructor() {
        TaskState copy = new TaskState(state);
        assertEquals(copy.getTask(), state.getTask());
        assertEquals(copy.getPreviousProject(), state.getPreviousProject());
    }

    @Test
    void setAndGetTask() {
        Task task = new Task("name");
        state.setTask(task);
        assertEquals(task, state.getTask());
    }

    @Test
    void setAndGetPreviousProject() {
        Project project = new Project("name");
        state.setPreviousProject(project);
        assertEquals(project, state.getPreviousProject());
    }

}
