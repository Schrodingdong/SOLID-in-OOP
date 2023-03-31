package com.schrodingdong.right;

import java.io.IOException;
import com.schrodingdong.Data;

public class Main {
    public static void main(String[] args) {
        // initialise classes
        DataFetcher dataFetcher = new DataFetcher("https://dummyjson.com/products/1");
        IDataMapper<Data> myMapper = new DataToObjectMapper<>(Data.class);
        IDataFileWriter fileWriter = new DataToFileWriter();
        try {
            // Fetching
            String jsonString = dataFetcher.fetchData();
            // Mapping
            Data data = myMapper.map(jsonString);
            System.out.println(data.toString());
            // To File
            fileWriter.writeToFile("myData.json", jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
