package use_case.select_add_project;

import entity.Project;
import entity.User;

public class SelectAddProjectInteractor implements SelectAddProjectInputBoundary {
    final SelectAddProjectOutputBoundary selectAddProjectPresenter;

    public SelectAddProjectInteractor(SelectAddProjectOutputBoundary selectAddProjectPresenter) {
        this.selectAddProjectPresenter = selectAddProjectPresenter;
    }

    @Override
    public void execute(SelectAddProjectInputData selectAddProjectInputData) {
        User user = selectAddProjectInputData.getUser();

        SelectAddProjectOutputData selectAddProjectOutputData = new SelectAddProjectOutputData(user);
        selectAddProjectPresenter.prepareSuccessView(selectAddProjectOutputData);

    }
}
