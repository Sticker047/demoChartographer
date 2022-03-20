package com.sticker.demochartographer.repos;

import com.sticker.demochartographer.exception.ChartaNotFoundException;
import com.sticker.demochartographer.object.Charta;
import com.sticker.demochartographer.services.Starter;

import java.util.HashMap;
import java.util.Map;

public class ChartaRepo {

    private static Map<Long, Charta> storage = new HashMap<>();

    private ChartaRepo() {

    }

    static {
        Starter.initChartaRepo();
    }

    public static long save(Charta canvas) {
        long id = storage.size();
        storage.put(id, canvas);
        return id;
    }

    public static Charta findById(Long id) throws ChartaNotFoundException {
        if (storage.get(id) != null) {
            return storage.get(id);
        } else {
            throw new ChartaNotFoundException("Папирус не найден");
        }
    }

    public static void deleteById(Long id) {
        storage.remove(id);
    }
}
