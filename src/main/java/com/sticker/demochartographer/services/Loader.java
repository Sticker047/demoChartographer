package com.sticker.demochartographer.services;

import com.sticker.demochartographer.object.Charta;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;

public class Loader implements Serializable {
    public final long serialVersionUID = 42L;

    @Value("path")
    private static String pathToDirectory = "C:\\Users\\gagil\\OneDrive\\Рабочий стол\\demoChartographer\\src\\main\\resources\\chartas\\";

    public static Charta loadCharta(long id) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(pathToDirectory + "charta_" + id + ".char");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Charta charta = (Charta) ois.readObject();
        return charta;
    }
}
