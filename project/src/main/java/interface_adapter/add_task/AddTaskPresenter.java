package project.src.main.java.interface_adapter.add_task;

import project.src.main.java.interface_adapter.ViewManagerModel;

public class AddTaskPresenter implements AddTaskOutputBoundary {

    private final AddTaskViewModel addTaskViewModel;
    private ViewManagerModel viewManagerModel;

    public AddTaskPresenter(ViewManagerModel viewManagerModel,
                            AddTaskViewModel addTaskViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addTaskViewModel = addTaskViewModel;
    }
}
