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

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.todoist.com/rest/v2/projects")
                .addHeader("Authorization", "Bearer " + TodoistAPI)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        }

    }
}
