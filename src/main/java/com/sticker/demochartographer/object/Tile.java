package com.sticker.demochartographer.object;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;

@Data
@NoArgsConstructor
public class Tile {
    private long id;
    private int width;
    private int height;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    private int positionX;
    private int positionY;

    private Canvas canvas;
}
