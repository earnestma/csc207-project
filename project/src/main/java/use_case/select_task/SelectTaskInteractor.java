package use_case.select_task;

import entity.Task;

public class SelectTaskInteractor implements SelectTaskInputBoundary{
    final SelectTaskOutputBoundary selectTaskPresenter;
    
    public SelectTaskInteractor(SelectTaskOutputBoundary selectTaskPresenter){
        this.selectTaskPresenter = selectTaskPresenter;
    }
    @Override
    public void execute(SelectTaskInputData selectTaskInputData) {
        Task task = selectTaskInputData.getTask();
        
        SelectTaskOutputData selectTaskOutputData = new SelectTaskOutputData(task);
        selectTaskPresenter.prepareSuccessView(selectTaskOutputData);
    }
}
