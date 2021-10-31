package com.epam.textparser.fileloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {

    private static final Logger Log = LoggerFactory.getLogger(FileLoader.class.getSimpleName());

    public String readFile() {
        Log.info("Creating classLoader.");
        String path = getPathOfFile();
        int c = 0;
        StringBuilder stringBuilder = new StringBuilder();
        Log.info("Reading file...");
        try (FileReader reader = new FileReader(path)) {
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
        } catch (IOException ex) {
            Log.error("IllegalState exception, cause file won't be found");
            System.err.println(ex.getMessage());
        }
        return stringBuilder.toString();
    }

    private String getPathOfFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResource("SomeFile.txt").getPath();
    }
}