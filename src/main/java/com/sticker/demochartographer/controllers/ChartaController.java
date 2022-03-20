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
    @PostMapping
    public ResponseEntity createCharta(
            @RequestParam int width,
            @RequestParam int height
    ) {
        try {
            return ResponseEntity.status(201).body(chartaService.createCharta(width, height));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Неверно указан размер папируса");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Произошла ошибка: " + e.getMessage());
        }
    }

    //DELETE /chartas/{id}/
    @DeleteMapping("/{id}/")
    public ResponseEntity deleteCharta(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(chartaService.delete(id));
        } catch (ChartaNotFoundException e) {
            return ResponseEntity.status(404).build();
        } catch (Exception e){
            return ResponseEntity.status(400).body("Произошла ошибка");
        }
    }

}
