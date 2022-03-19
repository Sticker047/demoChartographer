package com.sticker.demochartographer.repos;

import com.sticker.demochartographer.object.Canvas;

import java.util.HashMap;
import java.util.Map;

public class CanvasRepo {

    private static Map<Long, Canvas> storage;

    private CanvasRepo() {

    }

    public static Map getInstance() {
        if (storage == null) {
            synchronized (CanvasRepo.class) {
                if (storage == null){
                    storage = new HashMap<>();
                }
            }
        }

        return storage;
    }

    public static long save(Canvas canvas) {
        long id = storage.size();
        storage.put(id, canvas);
        return id;
    }

    public static Canvas findById(Long id) {
        return storage.get(id);
    }

    public static void deleteById(Long id) {
        storage.remove(id);
    }
}
