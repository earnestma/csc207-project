package use_case.select_task;

import entity.Project;
import entity.Task;

public class SelectTaskInteractor implements SelectTaskInputBoundary {
    final SelectTaskOutputBoundary selectTaskPresenter;

    public SelectTaskInteractor(SelectTaskOutputBoundary selectTaskPresenter) {
        this.selectTaskPresenter = selectTaskPresenter;
    }

    @Override
    public void execute(SelectTaskInputData selectTaskInputData) {
        Task task = selectTaskInputData.getTask();
        Project project = selectTaskInputData.getProject();

        SelectTaskOutputData selectTaskOutputData = new SelectTaskOutputData(task, project);
        selectTaskPresenter.prepareSuccessView(selectTaskOutputData);
    }
}
