package org.java.web.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class File {
    public void write(String fileName, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName, true);
        fileWriter.write(text);
        fileWriter.close();
    }

}