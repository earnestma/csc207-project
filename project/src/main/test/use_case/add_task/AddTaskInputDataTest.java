package use_case.add_task;

import org.junit.jupiter.api.BeforeEach;
import entity.Project;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AddTaskInputDataTest {
    AddTaskInputData data;
    Project project;

    @BeforeEach
    void init() {
        project = new Project("project name");
        data = new AddTaskInputData("name", "date", project);
    }

    @Test
    void getTaskName() {
        assertEquals("name", data.getTaskName());
    }

    @Test
    void getDueDate() {
        assertEquals("date", data.getDueDate());
    }

    @Test
    void getProject() {
        assertEquals(project, data.getProject());
    }

}
