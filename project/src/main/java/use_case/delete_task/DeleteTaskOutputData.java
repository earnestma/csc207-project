package use_case.delete_task;

import entity.Task;

import java.util.ArrayList;

public class DeleteTaskOutputData {
    private ArrayList<Task> taskList;
    private boolean useCaseFailed;
    
    public DeleteTaskOutputData(ArrayList<Task> taskList,
                                boolean useCaseFailed) {
        this.taskList = taskList;
        this.useCaseFailed = useCaseFailed;
    }
    
    public ArrayList<Task> getTaskList(){return taskList;}
}
