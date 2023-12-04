package interface_adapter.select_add_task;

import entity.Project;
import interface_adapter.ViewModelManager;
import interface_adapter.add_task.AddTaskViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.select_add_task.SelectAddTaskOutputData;

import static org.junit.Assert.assertEquals;

public class SelectAddTaskPresenterTest {
    SelectAddTaskPresenter presenter;
    ViewModelManager viewModelManager;
    AddTaskViewModel addTaskViewModel;

    @BeforeEach
    void init() {
        viewModelManager = new ViewModelManager();
        addTaskViewModel = new AddTaskViewModel();
        presenter = new SelectAddTaskPresenter(viewModelManager, addTaskViewModel);
    }

    @Test
    void prepareSuccessView() {
        Project project = new Project("name");
        SelectAddTaskOutputData data = new SelectAddTaskOutputData(project);

        presenter.prepareSuccessView(data);

        assertEquals(viewModelManager.getActiveView(), addTaskViewModel.getViewName());
    }
}
