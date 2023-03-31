package com.schrodingdong.wrong;

import com.schrodingdong.Data;

import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        DataFetcher dataFetcher = new DataFetcher("https://dummyjson.com/products/1");
        try {
            // Map to class
            String jsonString = dataFetcher.fetchData();
            Data data = dataFetcher.mapToClass(jsonString);
            System.out.println(data.toString());
            // write to file
            dataFetcher.writeToFile(jsonString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
