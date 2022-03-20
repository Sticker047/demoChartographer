package com.sticker.demochartographer.services;

import com.sticker.demochartographer.exception.ChartaNotFoundException;
import com.sticker.demochartographer.object.Charta;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deleter {
    public static final long serialVersionUID = 42L;
    @Value("${path}")
    private static String pathToDirectory = "C:\\Users\\gagil\\OneDrive\\Рабочий стол\\demoChartographer\\src\\main\\resources\\chartas\\";

    public static void deleteCharta(long id) throws IOException, ChartaNotFoundException {
        try {
            Stream<Path> str = Files.walk(Path.of(pathToDirectory));
            str.forEach(e -> {
                if (!e.equals(Path.of(pathToDirectory))) {
                    String fileName = e.getFileName().toString();
                    if (id == Long.valueOf(fileName.substring(6, fileName.lastIndexOf('.')))) {
                        try {
                            Files.delete(e);
                            return;
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new ChartaNotFoundException("Папирус не найден");
    }
}
