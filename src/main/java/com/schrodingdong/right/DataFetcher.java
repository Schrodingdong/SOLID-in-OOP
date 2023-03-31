package com.schrodingdong.right;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataFetcher {
    private String urlString;
    private URL url;
    public DataFetcher(String url){
        this.urlString = url;
        try {
            this.url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * fetchData() returns a JSON string response, that should be converted to the corresponding
     * com.schrodingdong.Data POJO.
     * */
    public String fetchData() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response = getStringBuilder(connection.getInputStream());

        return response.toString();
    }

    private StringBuilder getStringBuilder(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            response.append(line);
        }
        return response;
    }
}
