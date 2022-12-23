package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        //Create a URL object
        URL url = new URL("http://localhost:8080/library");

//Create an HttpURLConnection object
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

//Set the request method
        con.setRequestMethod("GET");

//Set request headers
        con.setRequestProperty("Content-Type", "application/json");

//Get the response code
        int responseCode = con.getResponseCode();

//Read the response
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

//Print the response
        System.out.println(response.toString());


    }
}