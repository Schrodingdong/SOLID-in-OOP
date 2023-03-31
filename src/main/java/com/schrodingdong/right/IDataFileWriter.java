package com.schrodingdong.right;

import java.io.IOException;

public interface IDataFileWriter {
    void writeToFile(String filename, String stringData) throws IOException;
}
