package com.sticker.demochartographer.controllers;

import com.sticker.demochartographer.object.Tile;
import com.sticker.demochartographer.services.TileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@AllArgsConstructor
public class TileController {

    @Autowired
    private TileService tileService;

    //POST /chartas/{id}/?x={x}&y={y}&width={width}&height={height}
    @PostMapping(path = "/chartas")
    public ResponseEntity createTile(
            @RequestBody File file,
            @RequestParam Long id,
            @RequestParam Integer x,
            @RequestParam Integer y,
            @RequestParam Integer width,
            @RequestParam Integer height
    ) {
        try {
            tileService.createTile(file, id, x, y, width, height);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
