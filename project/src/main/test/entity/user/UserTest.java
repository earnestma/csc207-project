package entity.user;

import entity.Project;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private User user;
    private LocalDateTime date;

    @BeforeEach
    void init() {
        user = new User("name", "username", "123456");
    }

    @Test
    void getProjectList() {
        ArrayList<Project> projectList = new ArrayList<Project>();
        assertEquals(user.getProjectList(), projectList);
    }

    @Test
    void getUsername() {
        assertEquals("username", user.getUsername());
    }
}
