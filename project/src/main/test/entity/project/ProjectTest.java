package entity.project;

import entity.Project;
import entity.Task;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ProjectTest {
    private Project projectConstructor1;
    private Project projectConstructor2;
    private Project projectConstructor3;
    
    
    private Task task;
    
    @BeforeEach
    void init(){
        task = new Task("task name");
        HashMap<Long, Task> taskMap = new HashMap<>();
        taskMap.put(1L, task);
        
        projectConstructor1 = new Project("project name 1");
        projectConstructor2 = new Project("project name 2", 2);
        projectConstructor3 = new Project("project name 3",
                3, taskMap, false);
    }
    
    @Test
    void getName(){
        assertEquals("project name 3", projectConstructor3.getName());
    }
    
    @Test
    void setName(){
        projectConstructor1.setName("new name");
        assertEquals("new name", projectConstructor1.getName());
    }
    
    @Test
    void getId(){
        assertEquals(2, projectConstructor2.getId());
    }
    
    @Test
    void setId(){
        projectConstructor1.setId(4);
        assertEquals(4, projectConstructor1.getId());
    }
    
    @Test
    void getArchived(){
        assertEquals(false, projectConstructor3.getArchived());
    }
    
    @Test
    void setArchived(){
        projectConstructor3.setArchived(true);
        assertEquals(true, projectConstructor3.getArchived());
    }
    
    @Test
    void getTaskList(){
        ArrayList<Task> taskList = new ArrayList<>();
        taskList.add(task);
        assertEquals(projectConstructor3.getTaskList(), taskList);
    }
    
    @Test
    void getTask(){
        assertEquals(projectConstructor3.getTask(1L), task);
    }
    
    @Test
    void addTask(){
        Task task2 = new Task("task 2", 5L);
        projectConstructor3.addTask(task2);
        assertEquals(task2, projectConstructor3.getTask(5L));
    }
}
