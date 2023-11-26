package main.java.entity;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    final private String username;
    final private String password;
    private Map projects; // projects has {project1 id : project1, project2 id : project2...}

    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
        this.projects = new HashMap<Integer, Project>();
    }
}
