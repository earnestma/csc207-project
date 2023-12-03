package entity.task;

import entity.Task;
import entity.TaskFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class TaskTest {
    private Task task;
    private LocalDateTime date;
    
    @BeforeEach
    void init(){
        date = LocalDateTime.of(2023, 12, 12, 12, 12);
        task = new Task("task", date, 1L);
    }
    
    @Test
    void testConstructor1(){
        new Task("task 1");
    }
    
    @Test
    void testConstructor2(){
        new Task("task 2", 2L);
    }
    
    @Test
    void testConstructor3(){
        new Task("task 3", LocalDateTime.now());
    }
    
    @Test
    void testFactory(){
        TaskFactory factory = new TaskFactory();
        factory.create("factory", LocalDateTime.now());
    }
    @Test
    void getName(){
        assertEquals(task.getName(), "task");
    }
    
    @Test
    void setName(){
        task.setName("new name");
        assertEquals(task.getName(), "new name");
    }
    
    @Test
    void getID(){
        assertEquals(task.getID(), Long.valueOf(1));
    }
    
    @Test
    void setID(){
        task.setID(5L);
        assertEquals(task.getID(), Long.valueOf(5));
    }
    
    @Test
    void hasDueDate(){
        assertEquals(true, task.hasDueDate());
    }
    
    @Test
    void getDueDate(){
        assertEquals(date, task.getDueDate());
    }
    
    @Test
    void setDueDate(){
        LocalDateTime newDate = LocalDateTime.of(2023, 1, 1, 1, 1);
        task.setDueDate(newDate);
        assertEquals(true, task.hasDueDate());
        assertEquals(newDate, task.getDueDate());
    }
    
    @Test
    void removeDueDate(){
        task.removeDueDate();
        assertEquals(false, task.hasDueDate());
        assertEquals(null, task.getDueDate());
    }
    
    @Test
    void getComplete(){
        assertEquals(task.getCompleted(), false);
    }
    
    @Test
    void setComplete(){
        task.setCompleted();
        assertEquals(true, task.getCompleted());
    }
}
