package com.sticker.demochartographer.repos;

import com.sticker.demochartographer.object.Tile;

import java.util.HashMap;
import java.util.Map;

public class TileRepo {
    private static Map<Long, Tile> storage = new HashMap<>();

    public static void save(Tile tile) {
        storage.put((long)storage.size(), tile);
    }
}
