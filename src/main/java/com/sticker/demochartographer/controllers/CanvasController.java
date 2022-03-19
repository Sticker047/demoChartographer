package com.sticker.demochartographer.controllers;

import com.sticker.demochartographer.exception.CanvasNotFoundException;
import com.sticker.demochartographer.services.CanvasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/chartas")
public class CanvasController {

    @Autowired
    private CanvasService canvasService;

    //POST /chartas/?width={width}&height={height}
    @PostMapping(path = "chartas")
    public ResponseEntity createCanvas(
            @RequestParam int width,
            @RequestParam int height
    ) {

        if (width > 20000 || height > 50000) {
            return ResponseEntity.badRequest().body("Неверный размер изображения попируса");
        }

        try {
            return ResponseEntity.created(URI.create("/"))
                    .body(canvasService.createCanvas(width, height));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getOneCanvas(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(canvasService.getOne(id));
        } catch (CanvasNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteCanvas(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(canvasService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
