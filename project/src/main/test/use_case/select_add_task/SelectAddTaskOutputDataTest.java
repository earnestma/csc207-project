package use_case.select_add_task;

import entity.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class SelectAddTaskOutputDataTest {
    SelectAddTaskOutputData data;
    Project project;
    @BeforeEach
    void init(){
        data = new SelectAddTaskOutputData(project);
    }
    
    @Test
    void getProject(){
        assertEquals(data.getProject(), project);
    }
}
