package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;


public class FileReader {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());
    private final Mapper mapper = new Mapper();

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        Path path = Paths.get(file.getPath());

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            StringBuilder stringBuilder = new StringBuilder();

            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {
                stringBuilder.append(currentLine).append("\n");
            }

            profile = mapper.mapToProfile(stringBuilder.toString());
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return profile;
    }
}
