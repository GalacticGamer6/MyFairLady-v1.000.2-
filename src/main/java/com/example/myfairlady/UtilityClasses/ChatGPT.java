package com.example.myfairlady.UtilityClasses;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;

// all chatgpt's code lol
public class ChatGPT {

    private static String getKey() throws FileNotFoundException {

        Scanner sc = new Scanner(new File("key.txt"));
        String key = sc.nextLine();
        return key;

    }
    public static String url = "https://api.openai.com/v1/chat/completions";
    public static String api_key;

    static {
        try {
            api_key = getKey();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String model = "gpt-4";


    public static String askChatBot(String message) throws IOException {
        // Check if API key is available
        if (api_key == null || api_key.isEmpty()) {
            throw new IOException("API key is missing!");
        }

        // Create URL and HttpURLConnection objects
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Set HTTP method, headers, and output
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "Bearer " + api_key);
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        // Write request body

        //setup a JSON object to send to the API
        JSONArray messages = new JSONArray();
        messages.put(new JSONObject().put("role", "user").put("content", message));
        JSONObject json = new JSONObject();
        json.put("messages", messages);
        json.put("max_tokens", 150);
        json.put("temperature", 0.9);
        json.put("model", model);

        try (OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream())) {
            writer.write(json.toString());
            writer.flush();
        }

        // Read response
        StringBuilder response = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line;
            while ((line = input.readLine()) != null) {
                response.append(line).append("\n");
            }
        }

        // Print the raw API response for debugging
        System.out.println("Raw API Response: " + response.toString());

        return extractContentFromResponse(response.toString());
    }


    // This method extracts the response expected from chatgpt and returns it.
    public static String extractContentFromResponse(String response) {
        // Create a JSONObject from the response string
        JSONObject jsonResponse = new JSONObject(response);

        // Navigate through the JSON object to extract the content
        JSONArray choices = jsonResponse.getJSONArray("choices");
        JSONObject firstChoice = choices.getJSONObject(0);
        JSONObject message = firstChoice.getJSONObject("message");
        String content = message.getString("content");

        return content;
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println(getKey());
//    }

}
