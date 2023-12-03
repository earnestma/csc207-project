package interface_adapter.add_task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class AddTaskViewModelTest {
    AddTaskViewModel viewModel;
    @BeforeEach
    void init(){
        viewModel = new AddTaskViewModel();
    }
    
    @Test
    void setAndGetState(){
        AddTaskState state = new AddTaskState();
        viewModel.setState(state);
        assertEquals(viewModel.getState(), state);
    }
    
    @Test
    void setAndGetMessage(){
        viewModel.setMessage("message");
        assertEquals(viewModel.getMessage(), "message");
    }
}
