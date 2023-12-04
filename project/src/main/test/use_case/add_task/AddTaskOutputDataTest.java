package use_case.add_task;

import entity.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AddTaskOutputDataTest {
    AddTaskOutputData data;
    ArrayList<Task> taskList;

    @BeforeEach
    void init() {
        taskList = new ArrayList<>();
        data = new AddTaskOutputData("task",
                LocalDateTime.of(2023, 12, 12, 12, 12),
                taskList, false);
    }

    @Test
    void getTaskName() {
        assertEquals("task", data.getTaskName());
    }

    @Test
    void getDueDate() {
        assertEquals("2023-12-12", data.getDueDate());
    }

    @Test
    void getTaskList() {
        assertEquals(taskList, data.getTaskList());
    }
}
