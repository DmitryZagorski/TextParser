package com.epam.textparser.fileloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.stream.Collectors;

public class FileLoader {

    private static final Logger Log = LoggerFactory.getLogger(FileLoader.class.getSimpleName());

    public String readFile() {
        Log.info("Creating classLoader.");
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("SomeFile.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            return br.lines().collect(Collectors.joining("\n"));
            //return br.lines().collect(Collectors.joining());
        } catch (Exception e) {
            Log.error("Failed to read file", e);
            throw new RuntimeException(e);
        }
    }
}