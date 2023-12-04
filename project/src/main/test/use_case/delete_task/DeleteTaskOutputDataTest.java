package use_case.delete_task;

import entity.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeleteTaskOutputDataTest {
    DeleteTaskOutputData data;
    ArrayList<Task> taskList;

    @BeforeEach
    void init() {
        taskList = new ArrayList<>();
        data = new DeleteTaskOutputData(taskList, false);
    }

    @Test
    void getTaskList() {
        assertEquals(data.getTaskList(), taskList);
    }
}
