package com.sticker.demochartographer.object;

import com.sticker.demochartographer.exception.ChartaNotFoundException;
import com.sticker.demochartographer.repos.ChartaRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;
import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fragment {
    private long id;
    private int width;
    private int height;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    private int positionX;
    private int positionY;

    private Charta charta;

    public Fragment(File file, Long canvasId, Integer x, Integer y, Integer width, Integer height) throws ChartaNotFoundException {
        charta = ChartaRepo.findById(canvasId);
        positionX = x;
        positionY = y;
        this.width = width;
        this.height = height;
    }
}
