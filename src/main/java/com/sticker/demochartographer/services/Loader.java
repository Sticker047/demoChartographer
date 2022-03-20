package com.sticker.demochartographer.services;

import com.sticker.demochartographer.object.Charta;

import java.io.*;

public class Loader implements Serializable {
    public final long serialVersionUID = 42L;

    private String pathToDirectory = "C:\\Users\\gagil\\OneDrive\\Рабочий стол\\demoChartographer\\src\\main\\resources\\chartas\\";

    public Charta loadCharta(Long id) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(pathToDirectory + id + ".char");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Charta charta = (Charta) ois.readObject();
        return charta;
    }
}
