package entity;

public class ProjectFactory {
    public Project create(String projectName) {
        return new Project(projectName);
    }
}
