package use_case.select_delete_task;

import entity.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SelectDeleteTaskOutputDataTest {
    SelectDeleteTaskOutputData data;
    Project project;

    @BeforeEach
    void init() {
        data = new SelectDeleteTaskOutputData(project);
    }

    @Test
    void getProject() {
        assertEquals(data.getProject(), project);
    }
}
