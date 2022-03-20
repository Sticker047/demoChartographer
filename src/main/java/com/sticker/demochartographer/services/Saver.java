package com.sticker.demochartographer.services;

import com.sticker.demochartographer.object.Charta;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;

public class Saver {
    public static final long serialVersionUID = 42L;
    @Value("${path}")
    private static String pathToDirectory = "C:\\Users\\gagil\\OneDrive\\Рабочий стол\\demoChartographer\\src\\main\\resources\\chartas\\";

    public static void saveCharta(Charta charta) throws IOException {
        ObjectOutputStream out;

        File file = new File(pathToDirectory + "charta_" + charta.getId() + ".char");
        if (!file.exists()) {
            file.createNewFile();
        }
        out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(charta);

        out.flush();
        out.close();
    }
}
