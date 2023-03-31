package com.schrodingdong.wrong;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.schrodingdong.Data;
public class DataFetcher {
    private String urlString;
    private URL url;
    private String filename = "data.json";
    DataFetcher(String url){
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
    /**
     * Maps a JSON string to the com.schrodingdong.Data Object.
     * */
    public Data mapToClass(String response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, Data.class);
    }

    /**
     * Writes to a file "data.json" the data
     * */
    public void writeToFile(String data){
        File f = new File(filename);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write(data);
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
