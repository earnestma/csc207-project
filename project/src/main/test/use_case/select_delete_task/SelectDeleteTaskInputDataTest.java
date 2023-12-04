package use_case.select_delete_task;

import entity.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SelectDeleteTaskInputDataTest {
    SelectDeleteTaskInputData data;
    Project project;

    @BeforeEach
    void init() {
        data = new SelectDeleteTaskInputData(project);
    }

    @Test
    void getProject() {
        assertEquals(data.getProject(), project);
    }
}
