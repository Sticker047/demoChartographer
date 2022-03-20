package com.sticker.demochartographer.services;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Starter {

    @Value("${path}")
    private static String pathToDirectory = "C:\\Users\\gagil\\OneDrive\\Рабочий стол\\demoChartographer\\src\\main\\resources\\chartas\\";

    public static void initChartaRepo() {


        try {
            Stream<Path> paths = Files.walk(Path.of(pathToDirectory));
            paths.forEach(e -> {
                if (!e.equals(Path.of(pathToDirectory))) {
                    String filename = e.getFileName().toString();
                    try {
                        Loader.loadCharta(Long.getLong(filename.substring(0, filename.lastIndexOf('.'))));
                    } catch (Exception ex) {

                    }
                }
            });
        } catch (IOException e) {

        }
    }

}
