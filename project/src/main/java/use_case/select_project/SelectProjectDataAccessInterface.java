package use_case.select_project;

import entity.Task;

import java.util.ArrayList;

public interface SelectProjectDataAccessInterface {
    ArrayList<Task> getTasks(long projectID);
}
