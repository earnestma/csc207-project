package use_case.delete_task;

import org.junit.jupiter.api.BeforeEach;

import entity.Project;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DeleteTaskInputDataTest{
    DeleteTaskInputData data;
    Project project;
    
    @BeforeEach
    void init() {
        project = new Project("project name");
        data = new DeleteTaskInputData("name", project);
    }
    
    @Test
    void getTaskName(){
        assertEquals(data.getTaskName(), "name");
    }
    
    @Test
    void getProject(){
        assertEquals(data.getProject(), project);
    }
}
