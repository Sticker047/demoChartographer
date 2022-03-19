package com.sticker.demochartographer.object;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Canvas {

    private long id;
    private int width;
    private int height;
    private List<Tile> tiles;
}
