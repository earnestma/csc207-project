package interface_adapter.select_delete_project;

import entity.User;
import use_case.select_delete_project.SelectDeleteProjectInputBoundary;
import use_case.select_delete_project.SelectDeleteProjectInputData;

public class SelectDeleteProjectController {
    final SelectDeleteProjectInputBoundary selectDeleteProjectInteractor;

    public SelectDeleteProjectController(SelectDeleteProjectInputBoundary selectDeleteProjectInteractor) {
        this.selectDeleteProjectInteractor = selectDeleteProjectInteractor;
    }

    public void execute(User user) {
        SelectDeleteProjectInputData selectDeleteProjectInputData = new SelectDeleteProjectInputData(user);

        selectDeleteProjectInteractor.execute(selectDeleteProjectInputData);
    }
}
