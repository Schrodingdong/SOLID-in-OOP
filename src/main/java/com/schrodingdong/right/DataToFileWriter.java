package com.schrodingdong.right;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataToFileWriter implements IDataFileWriter{
    @Override
    public void writeToFile(String filename, String stringData) throws IOException {
        File f = new File(filename);
        BufferedWriter writer = new BufferedWriter(new FileWriter(f));
        writer.write(stringData);
        writer.close();
    }
}
