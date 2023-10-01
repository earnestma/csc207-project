package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import okhttp3.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("todoist_api.txt");
        Scanner sc = new Scanner(file);
        String TodoistAPI = sc.next();
        sc.close();

        File fileT = new File("todoist_api.txt");
        Scanner scT = new Scanner(fileT);
        String TogglAPI = scT.next();
        scT.close();

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        System.out.println("==== Todoist API Demo ====");

        Request request = new Request.Builder()
                .url("https://api.todoist.com/rest/v2/projects")
                .addHeader("Authorization", "Bearer " + TodoistAPI)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        }

        System.out.println("==== Toggl API Demo ====");
        // Toggl requires your info in toggl_api.txt as <email>:<password>

        Request tRequest = new Request.Builder()
                .url("https://api.track.toggl.com/api/v9/me/time_entries/current")
                .addHeader("Authorization", "Basic " + TogglAPI)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(tRequest).execute()) {
            System.out.println(response.body().string());
        }

    }
}
