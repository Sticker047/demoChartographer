package com.sticker.demochartographer.services;

import com.sticker.demochartographer.object.Canvas;
import com.sticker.demochartographer.object.Tile;
import com.sticker.demochartographer.repos.CanvasRepo;
import com.sticker.demochartographer.repos.TileRepo;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class TileService {

    public void createTile(File file, Long canvasId, Integer x, Integer y, Integer width, Integer height) {

        Tile tile = new Tile();
        tile.setCanvas(CanvasRepo.findById(canvasId));
        tile.setWidth(width);
        tile.setHeight(height);
        tile.setPositionX(x);
        tile.setPositionY(y);


    }
}
