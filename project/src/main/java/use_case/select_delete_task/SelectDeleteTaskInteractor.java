package use_case.select_delete_task;

import entity.Project;

public class SelectDeleteTaskInteractor implements SelectDeleteTaskInputBoundary {
    final SelectDeleteTaskOutputBoundary selectDeleteTaskPresenter;

    public SelectDeleteTaskInteractor(SelectDeleteTaskOutputBoundary selectDeleteTaskPresenter) {
        this.selectDeleteTaskPresenter = selectDeleteTaskPresenter;
    }
    @Override
    public void execute(SelectDeleteTaskInputData selectDeleteTaskInputData) {
        Project project = selectDeleteTaskInputData.getProject();

        SelectDeleteTaskOutputData selectDeleteTaskOutputData = new SelectDeleteTaskOutputData(project);
        selectDeleteTaskPresenter.prepareSuccessView(selectDeleteTaskOutputData);
    }
}
