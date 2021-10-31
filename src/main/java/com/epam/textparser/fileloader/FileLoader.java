package com.epam.textparser.fileloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {

    private static final Logger Log = LoggerFactory.getLogger(FileLoader.class.getSimpleName());

    public String readFile() {
        Log.info("Creating classLoader.");
        String path = getPathOfFile();
        int c;
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
        String a = null;
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            a = classLoader.getResource("SomeFile.txt").getPath();
        } catch (Exception e) {
            Log.error("NullPointerException, cause file won't be found");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return a;

    }
}