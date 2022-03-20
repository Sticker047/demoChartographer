package com.sticker.demochartographer.controllers;

import com.sticker.demochartographer.exception.ChartaNotFoundException;
import com.sticker.demochartographer.object.Fragment;
import com.sticker.demochartographer.repos.ChartaRepo;
import com.sticker.demochartographer.services.FragmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.File;

@RestController
@AllArgsConstructor
public class FragmentController {

    @Autowired
    private FragmentService tileService;

    //POST /chartas/{id}/?x={x}&y={y}&width={width}&height={height}
    //file.getResource().getFile()
    @PostMapping(path = "/chartas/{id}/")
    public ResponseEntity createFragment(@RequestBody File file,
                                         @PathVariable Long id,
                                         @RequestParam Integer x,
                                         @RequestParam Integer y,
                                         @RequestParam Integer width,
                                         @RequestParam Integer height) {
        try {
            tileService.createFragment(file, id, x, y, width, height);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // GET /chartas/{id}/?x={x}&y={y}&width={width}&height={height}

    @GetMapping(path = "/chartas/{id}/")
    public BufferedImage getFragment(@PathVariable Long id,
                                     @RequestParam int width,
                                     @RequestParam int height,
                                     @RequestParam int x,
                                     @RequestParam int y) throws ChartaNotFoundException {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x0 = 0; x0 < width; x0++) {
            for (int y0 = 0; y0 < height; y0++)
                image.setRGB(x0, y0, 0xff000000);
        }

        for (Fragment fragment : ChartaRepo.findById(id).getFragments()) {
            if (fragment.getPositionX() > x || fragment.getPositionX() + fragment.getWidth() < x + width) {
                if (fragment.getPositionY() > y || fragment.getPositionY() + fragment.getHeight() < y + height) {
                    for (int xD = 0; xD < width; xD++) {
                        for (int yD = 0; yD < height; yD++) {
                            image.setRGB(xD, yD, fragment.getImage().getRGB(x + xD, y + yD));
                        }
                    }
                } else return null;
            }
        }
        return image;
    }
}
