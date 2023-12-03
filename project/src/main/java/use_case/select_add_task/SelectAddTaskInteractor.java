package use_case.select_add_task;

import entity.Project;

public class SelectAddTaskInteractor implements SelectAddTaskInputBoundary {
    final SelectAddTaskOutputBoundary selectAddTaskPresenter;

    public SelectAddTaskInteractor(SelectAddTaskOutputBoundary selectAddTaskPresenter) {
        this.selectAddTaskPresenter = selectAddTaskPresenter;
    }

    @Override
    public void execute(SelectAddTaskInputData selectAddTaskInputData) {
        Project project = selectAddTaskInputData.getProject();

        SelectAddTaskOutputData selectAddTaskOutputData = new SelectAddTaskOutputData(project);
        selectAddTaskPresenter.prepareSuccessView(selectAddTaskOutputData);
    }
}
