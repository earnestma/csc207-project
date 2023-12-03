package interface_adapter.task;

import interface_adapter.add_task.AddTaskState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class TaskViewModelTest {
    TaskViewModel viewModel;
    
    @BeforeEach
    void init(){
        viewModel = new TaskViewModel();
    }
    
    @Test
    void setAndGetState(){
        TaskState state = new TaskState();
        viewModel.setState(state);
        assertEquals(viewModel.getState(), state);
    }
    
    @Test
    void setAndGetMessage(){
        viewModel.setMessage("message");
        assertEquals(viewModel.getMessage(), "message");
    }
}
