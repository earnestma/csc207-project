package data_access;

import entity.Project;
import entity.Task;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ProjectDataAccessObject implements ProjectDataAccessInterface {

    @Override
    public void modifyProject(Project project) {
        HttpClient client = HttpClient.newHttpClient();

        JSONObject projJSON = new JSONObject();
        projJSON.put("name", project.getName());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://api.todoist.com/rest/v2/projects/%d", project.getId())))
                .POST(BodyPublishers.ofString(projJSON.toString()))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + System.getenv("token"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new IOException("Project name could not be updated");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addTask(Project project, Task task) {
        HttpClient client = HttpClient.newHttpClient();

        JSONObject taskJSON = new JSONObject();

        taskJSON.put("content", task.getName());
        taskJSON.put("project_id", project.getId());
        taskJSON.put("priority", task.getPriority());

        if (task.hasDueDate()) {
            taskJSON.put("due_datetime", task.getDueDate().toString());
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.todoist.com/rest/v2/tasks"))
                .POST(BodyPublishers.ofString(taskJSON.toString()))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + System.getenv("token"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject a = new JSONObject(response.body());

                task.setID(a.getLong("id"));
            } else {
                throw new IOException("Task could not be created");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(Task task) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://api.todoist.com/rest/v2/tasks/%d", task.getID())))
                .DELETE()
                .setHeader("Authorization", "Bearer " + System.getenv("token"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 204) {
                throw new IOException("Task could not be deleted");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Task> getTasks(long projectID) {
        HttpClient client = HttpClient.newHttpClient();

        ArrayList<Task> taskList = new ArrayList<Task>();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://api.todoist.com/rest/v2/tasks?project_id=%d", projectID)))
                .GET()
                .setHeader("Authorization", "Bearer " + System.getenv("token"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONArray r = new JSONArray(response.body());

                for (int i = 0; i < r.length(); i++) {
                    JSONObject t = r.getJSONObject(i);
                    String tN = t.getString("content");
                    long tID = t.getLong("id");
                    int tP = t.getInt("priority");

                    if (t.isNull("due")) {
                        // no due date set
                        Task task = new Task(tN, tP, tID);
                        taskList.add(task);
                    } else {
                        JSONObject a = t.getJSONObject("due");

                        LocalDateTime date = LocalDateTime.parse(a.getString("datetime"),
                                DateTimeFormatter.ISO_LOCAL_DATE_TIME);

                        Task task = new Task(tN, tP, date, tID);
                        taskList.add(task);
                    }
                }

                return taskList;
            } else {
                throw new IOException("Tasks could not be retrieved");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    @Override
    public void modifyTask(Project project, Task task) {
        HttpClient client = HttpClient.newHttpClient();

        JSONObject taskJSON = new JSONObject();

        taskJSON.put("content", task.getName());
        taskJSON.put("priority", task.getPriority());

        if (task.hasDueDate()) {
            taskJSON.put("due_datetime", task.getDueDate().toString());
        } else {
            taskJSON.put("due_string", "no date");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://api.todoist.com/rest/v2/tasks/%d", task.getID())))
                .POST(BodyPublishers.ofString(taskJSON.toString()))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + System.getenv("token"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 204) {
                throw new IOException("Task could not be updated");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
