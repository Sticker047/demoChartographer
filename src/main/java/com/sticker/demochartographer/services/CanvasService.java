package com.sticker.demochartographer.services;

import com.sticker.demochartographer.exception.CanvasNotFoundException;
import com.sticker.demochartographer.object.Canvas;
import com.sticker.demochartographer.repos.CanvasRepo;
import org.springframework.stereotype.Service;

@Service
public class CanvasService {

    public Canvas getOne(Long id) throws CanvasNotFoundException {
        Canvas canvas = CanvasRepo.findById(id);
        if (canvas == null) {
            throw new CanvasNotFoundException("Холст не найден");
        }
        return canvas;
    }

    public Long delete(Long id) {
        CanvasRepo.deleteById(id);
        return id;
    }

    public long createCanvas(int width, int height) {
        Canvas canvas = new Canvas();
        canvas.setWidth(width);
        canvas.setHeight(height);
        return CanvasRepo.save(canvas);
    }
}
