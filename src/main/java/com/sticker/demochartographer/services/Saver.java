package com.sticker.demochartographer.services;

import com.sticker.demochartographer.object.Charta;

import java.io.*;

public class Saver {
    public final long serialVersionUID = 42L;
    private String pathToDirectory = "C:\\Users\\gagil\\OneDrive\\Рабочий стол\\demoChartographer\\src\\main\\resources\\chartas\\";

    public void saveCharta(Charta charta) throws IOException {
        ObjectOutputStream out;

        File file = new File(pathToDirectory + charta.getId() + ".char");
        if (!file.exists()) {
            file.createNewFile();
        }
        out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(charta);

        out.flush();
        out.close();
    }
}
