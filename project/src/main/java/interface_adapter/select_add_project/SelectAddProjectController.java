package interface_adapter.select_add_project;

import entity.User;

import use_case.select_add_project.SelectAddProjectInputBoundary;
import use_case.select_add_project.SelectAddProjectInputData;
import use_case.select_project.SelectProjectInputData;

public class SelectAddProjectController {
    final SelectAddProjectInputBoundary selectAddProjectInteractor;

    public SelectAddProjectController(SelectAddProjectInputBoundary selectAddProjectInputBoundary) {
        this.selectAddProjectInteractor = selectAddProjectInputBoundary;
    }

    public void execute(User user) {
        SelectAddProjectInputData selectAddProjectInputData = new SelectAddProjectInputData(user);

        selectAddProjectInteractor.execute(selectAddProjectInputData);
    }
}
