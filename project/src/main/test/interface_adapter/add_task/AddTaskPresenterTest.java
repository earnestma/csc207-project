package interface_adapter.add_task;

import entity.Task;
import interface_adapter.ViewModelManager;
import interface_adapter.project.ProjectViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.add_task.AddTaskOutputData;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AddTaskPresenterTest {
    AddTaskPresenter presenter;
    ViewModelManager viewModelManager;
    AddTaskViewModel addTaskViewModel;
    ProjectViewModel projectViewModel;
    
    @BeforeEach
    void init(){
        viewModelManager = new ViewModelManager();
        addTaskViewModel = new AddTaskViewModel();
        projectViewModel = new ProjectViewModel();
        presenter = new AddTaskPresenter(viewModelManager, addTaskViewModel, projectViewModel);
    }
    
    @Test
    void prepareSuccessView(){
        Task task = new Task("name");
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(task);
        LocalDateTime date = LocalDateTime.of(2023, 12, 12, 12, 12);
        
        AddTaskOutputData data = new AddTaskOutputData("name", date, taskList, false);
        presenter.prepareSuccessView(data);
        
        assertEquals(viewModelManager.getActiveView(), projectViewModel.getViewName());
    }
    
    @Test
    void prepareFailView(){
        presenter.prepareFailView("error");
        assertEquals(addTaskViewModel.getMessage(), "error");
    }
}
