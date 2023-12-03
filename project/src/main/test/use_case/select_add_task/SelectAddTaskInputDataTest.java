package use_case.select_add_task;

import entity.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SelectAddTaskInputDataTest {
    SelectAddTaskInputData data;
    Project project;
    @BeforeEach
    void init(){
        data = new SelectAddTaskInputData(project);
    }
    
    @Test
    void getProject(){
        assertEquals(data.getProject(), project);
    }
}
