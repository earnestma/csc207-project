package use_case.select_delete_project;

import entity.User;

public class SelectDeleteProjectInteractor implements SelectDeleteProjectInputBoundary {
    final SelectDeleteProjectOutputBoundary selectDeleteProjectPresenter;

    public SelectDeleteProjectInteractor(SelectDeleteProjectOutputBoundary selectDeleteProjectPresenter) {
        this.selectDeleteProjectPresenter = selectDeleteProjectPresenter;
    }

    @Override
    public void execute(SelectDeleteProjectInputData selectDeleteProjectInputData) {
        User user = selectDeleteProjectInputData.getUser();

        SelectDeleteProjectOutputData selectDeleteProjectOutputData = new SelectDeleteProjectOutputData(user);
        selectDeleteProjectPresenter.prepareSuccessView(selectDeleteProjectOutputData);
    }
}
