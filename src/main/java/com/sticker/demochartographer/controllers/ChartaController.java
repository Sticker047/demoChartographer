package com.sticker.demochartographer.controllers;

import com.sticker.demochartographer.exception.ChartaNotFoundException;
import com.sticker.demochartographer.services.ChartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/chartas")
public class ChartaController {

    @Autowired
    private ChartaService chartaService;

    //POST /chartas/?width={width}&height={height}
    @PostMapping(path = "chartas")
    public ResponseEntity createCharta(
            @RequestParam int width,
            @RequestParam int height
    ) {
        try {
            return ResponseEntity.status(201).body(chartaService.createCharta(width, height));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Неверно указан размер папируса");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Произошла ошибка: " + e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getCharta(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(chartaService.getCharta(id));
        } catch (ChartaNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    //DELETE /chartas/{id}/
    @DeleteMapping
    public ResponseEntity deleteCharta(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(chartaService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
