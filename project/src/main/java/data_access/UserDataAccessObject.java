package data_access;

import entity.Project;
import use_case.add_project.AddProjectDataAccessInterface;

import org.json.JSONArray;
import org.json.JSONObject;
import use_case.delete_project.DeleteProjectDataAccessInterface;

import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class UserDataAccessObject
        implements UserDataAccessInterface, AddProjectDataAccessInterface, DeleteProjectDataAccessInterface {

    @Override
    public void addProject(Project project) {
        HttpClient client = HttpClient.newHttpClient();

        JSONObject projJSON = new JSONObject();

        projJSON.put("name", project.getName());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.todoist.com/rest/v2/projects"))
                .POST(BodyPublishers.ofString(projJSON.toString()))
                .setHeader("Content-Type", "application/json")
                .setHeader("Authorization", "Bearer " + System.getenv("token"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject JSONResp = new JSONObject(response.body());
                // set the project id for our own use
                project.setId(JSONResp.getLong("id"));

            } else {
                throw new IOException("Error creating project");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProject(Project project) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://api.todoist.com/rest/v2/projects/%d", project.getId())))
                .DELETE()
                .setHeader("Authorization", "Bearer " + System.getenv("token"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 204) {
                throw new IOException("Project could not be deleted");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Project> listProjects() {
        ArrayList<Project> projects = new ArrayList<Project>();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.todoist.com/rest/v2/projects"))
                .GET()
                .setHeader("Authorization", "Bearer " + System.getenv("token"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONArray r = new JSONArray(response.body());

                for (int i = 0; i < r.length(); i++) {
                    JSONObject p = r.getJSONObject(i);
                    String pName = p.getString("name");
                    Long pID = p.getLong("id");

                    Project pr = new Project(pName, pID);

                    projects.add(pr);
                }
            } else {
                throw new IOException("Cannot get list of all projects.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return projects;
    }

}