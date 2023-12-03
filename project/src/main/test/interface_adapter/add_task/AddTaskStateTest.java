package interface_adapter.add_task;

import entity.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AddTaskStateTest {
    AddTaskState state;
    
    @BeforeEach
    void init() {
        state = new AddTaskState();
    }
    
    @Test
    void constructor(){
        AddTaskState copy = new AddTaskState(state);
        assertEquals(copy.getTaskName(), state.getTaskName());
        assertEquals(copy.getTaskNameError(), state.getTaskNameError());
        assertEquals(copy.getDueDate(), state.getDueDate());
        assertEquals(copy.getDueDateError(), state.getDueDateError());
        assertEquals(copy.getProject(), state.getProject());
    }
    
    @Test
    void getTaskName() {
        assertEquals("", state.getTaskName());
    }
    
    @Test
    void getTaskNameError() {
        assertEquals(null, state.getTaskNameError());
    }
    
    @Test
    void getDueDate() {
        assertEquals("", state.getDueDate());
    }
    
    @Test
    void getDueDateError() {
        assertEquals(null, state.getDueDateError());
    }
    
    @Test
    void setTaskName() {
        state.setTaskName("new name");
        assertEquals(state.getTaskName(), "new name");
    }
    
    @Test
    void setTaskNameError() {
        state.setTaskNameError("error");
        assertEquals(state.getTaskNameError(), "error");
    }
    
    @Test
    void setDueDate() {
        state.setDueDate("2023-12-12");
        assertEquals(state.getDueDate(), "2023-12-12");
    }
    
    @Test
    void setDueDateError() {
        state.setDueDateError("error");
        assertEquals(state.getDueDateError(), "error");
    }
    
    @Test
    void setAndGetProject() {
        Project project = new Project("name");
        state.setProject(project);
        assertEquals(state.getProject(), project);
    }
}
